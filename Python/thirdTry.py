import logging
	
logging.basicConfig(filename="log.log", level=logging.INFO)

logger = logging.getLogger("meinLogger")
logger.setLevel(logging.DEBUG)
fileh = logging.FileHandler("logme.txt")
form = logging.Formatter('%(name)s - %(levelname)s : %(asctime)s - %(message)s')
fileh.setFormatter(form)
logger.addHandler(fileh)
logger.debug("debugging")
logging.info("dies ist eine info")

import re
x = re.search("0{3}(?P<teil2>-0+1)", '000-01')
print(x.span()[1])