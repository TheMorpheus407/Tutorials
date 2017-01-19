import pygame, sys
import pygame.locals
pygame.init()
window = pygame.display.set_mode((1,1), 0, 32)
window.fill((0,0,0))
f = open("log.txt", "w")
while True:
    for event in pygame.event.get():
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_a:
                f.write("a")
            if event.key == pygame.K_b:
                f.write("b")
            if event.key == pygame.K_c:
                f.write("c")
            if event.key == pygame.K_d:
                f.write("d")
            if event.key == pygame.K_e:
                f.write("e")
            if event.key == pygame.K_f:
                f.write("f")
            if event.key == pygame.K_g:
                f.write("g")
            if event.key == pygame.K_h:
                f.write("h")
