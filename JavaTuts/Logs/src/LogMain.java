import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogMain {
	private Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public LogMain(){
		Logger root = Logger.getLogger("");
		FileHandler txt = null;
		try
		{
			txt = new FileHandler("Log.txt");
		} catch (SecurityException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root.setLevel(Level.ALL);
		txt.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record)
			{
				String ret = "";
				if(record.getLevel().intValue() >= Level.WARNING.intValue())
				{
					ret += "ATTENTION!:";
				}
				ret += record.getLevel();
				SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm");
				Date d = new Date(record.getMillis());
				ret += df.format(d);
				
				ret += this.formatMessage(record);
				ret += "\r\n";
				return ret;
			}
		});
		root.addHandler(txt);
	}
	

	public static void main(String[] args)
	{
		LogMain lm = new LogMain();
		lm.dosth();
	}


	private void dosth()
	{
		//do sth
		log.setLevel(Level.ALL);
		log.severe("ERROR STH TERRIBLE HAPPENED");
		log.warning("Maybe something bad happened, i'll try sth different");
		log.info("running smooth");
		log.fine("i'm feeling great thx");
	}

}
