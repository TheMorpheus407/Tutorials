import pyshark

cap = pyshark.LiveCapture(interface='enp0s25')
for packet in cap.sniff_continuously():
    if 'IP' in packet:
        packet['IP'].src