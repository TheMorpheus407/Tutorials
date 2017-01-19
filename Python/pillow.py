print("\u2622")
exit()
input = "Python.jpg"
im = Image.open(input)
width = im.size[0]
height = im.size[1]

source = im.split()
zs = source[0].point(lambda i: i < 50 and 255)
zs2 = source[1].point(lambda i: i + 100)
source[1].paste(zs2, None, zs)
im = Image.merge(im.mode, source)
im.save("PythonAbklatsch.jpg")

#for x in range(0, width):
#    for y in range(0, height):
#        pixel = (x, y)
#        rgb = im.getpixel(pixel)