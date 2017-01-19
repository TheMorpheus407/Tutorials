from PIL import Image, ExifTags

img = Image.open("/home/morpheus/Tuts/Python/Python.jpg")
for i, j in img._getexif().items():
    if i in ExifTags.TAGS:
        print(ExifTags.TAGS[i] + " - " + str(j))