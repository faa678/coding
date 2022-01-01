# -*- coding: UTF-8 -*-
# animation.py
 
# 导入需要的模块
import pygame, sys
from pygame.locals import *
import random
import pygame_textinput
 
# 初始化pygame
pygame.init()
textinput = pygame_textinput.TextInputVisualizer()
 
# 设置帧率（屏幕每秒刷新的次数）
FPS = 5

#import random
pre_route=list()    #宽度搜索得到的节点
q=list()    #队列结构控制循环次数
xx=[0,1,0,-1]   #右移、下移、左移、上移
yy=[1,0,-1,0]
visited=list()  #记录节点是否已遍历
father=list()   #每一个pre_route节点的父节点
route=list()
def bfs(l,x,y,m,n):
    visited=[[0 for i in range(len(l[0]))]for j in range(len(l))]
    visited[x][y]=1 #入口节点设置为已遍历
    q.append([x,y])
    while q:    #队列为空则结束循环
        now=q[0]
        q.pop(0)    #移除队列头结点
        for i in range(4):
            point=[now[0]+xx[i],now[1]+yy[i]]   #当前节点
            if point[0]<0 or point[1]<0 or point[0]>=len(l) or point[1]>=len(l[0]) or visited[point[0]][point[1]]==1 or l[point[0]][point[1]]==1:
                continue
            father.append(now)
            visited[point[0]][point[1]]=1
            q.append(point)
            pre_route.append(point)
            if point[0]==m and point[1]==n:
                print("success")
                return 1
    print("false")
    return 0

def get_route(father,pre_route):    #输出最短迷宫路径
    route=[pre_route[-1],father[-1]]
    for i in range(len(pre_route)-1,-1,-1):
        if pre_route[i]==route[-1]:
            route.append(father[i])
    route.reverse()
    print("迷宫最短路径为：\n",route)
    print("步长：",len(route)-1)
    return route

l=[[0,1,0,1,0,1,0,1,0,0,1,0],
   [0,0,0,0,1,0,0,0,1,0,0,0],
   [0,1,1,0,1,0,1,1,0,1,0,0],
   [0,1,0,0,0,0,0,0,0,0,1,0],
   [0,0,0,1,1,1,1,1,0,0,0,0],
   [1,1,0,0,1,0,0,0,1,0,0,1],
   [0,0,0,1,1,0,1,1,0,0,0,1],
   [1,0,1,0,0,0,0,0,1,0,1,0],
   [0,0,1,1,1,0,0,1,0,0,1,0],
   [1,1,0,0,0,1,1,0,1,0,0,0],
   [0,0,0,1,0,0,0,0,1,1,0,1],
   [1,1,1,0,0,1,0,0,1,1,0,0]]

# 获得pygame的时钟
clock = pygame.time.Clock()
 
# 设置窗口大小
screen = pygame.display.set_mode((500, 300), 0, 32)
 
# 设置标题
pygame.display.set_caption('迷宫')
 
# 定义颜色
white = (255, 255, 255)
black=(0,0,0)
gray = (128,128,128)
red = (200,0,0)
green = (0,200,0)
bright_red = (255,0,0)
bright_green = (0,255,0)
blue = (0,0,255)
color_inactive = (100, 100, 200)
color_active = (200, 200, 255)
color_start = color_inactive
color_end = color_inactive
text_start = ""
text_end = ""
active_start = False
active_end = False

def drawMap(l):
    for i in range(len(l)): 
        y = i*20 + 30
        for j in range(len(l[0])):
            x = j*20+125
            if l[i][j] == 0:
                pygame.draw.rect(screen,white,[x,y,20,20])
            elif l[i][j] == 1:
                pygame.draw.rect(screen,black,[x,y,20,20])
            else:
                pygame.draw.rect(screen,blue,[x,y,20,20])
            x += 10
        y += 10


def text_objects(text, font):
    textSurface = font.render(text, True, black)
    return textSurface, textSurface.get_rect()

def button (msg, x, y, w, h, ic, ac, action=None):
    mouse = pygame.mouse.get_pos()
    click = pygame.mouse.get_pressed()
    # print(click)
    pygame.draw.rect(screen, ac, (x,y,w,h))
    if x + w > mouse[0] > x and y + h > mouse[1] > y:
        if click[0] == 1 and action != None:
            action()
    smallText = pygame.font.SysFont('comicsansms', 20)
    textSurf, textRect = text_objects(msg, smallText)
    textRect.center = ( (x+(w/2)), (y+(h/2)))
    screen.blit(textSurf, textRect)

def start():
    global pre_route   #宽度搜索得到的节点
    global q   #队列结构控制循环次数
    global visited  #记录节点是否已遍历
    global father   #每一个pre_route节点的父节点
    global route
    pre_route = list()
    q = list()
    visited = list()
    father = list()
    route = list()
    a, b, c, d = 0, 0, 11, 11
    if text_start != "":
        a, b = list(map(int,text_start.split(",")))
    if text_end != "":
        c, d = list(map(int,text_end.split(",")))
    print(a, b)
    if bfs(l,a,b,c,d) == 1:
        route=get_route(father,pre_route)
        for i in range(len(l)):
            l[i]=list(l[i])
        for i in range(len(route)):
            l[route[i][0]][route[i][1]]=2
    return 

def reset():
    global pre_route   #宽度搜索得到的节点
    global q   #队列结构控制循环次数
    global visited  #记录节点是否已遍历
    global father   #每一个pre_route节点的父节点
    global route
    pre_route = list()
    q = list()
    visited = list()
    father = list()
    route = list()
    for i in range(len(l)):
        for j in range (len(l[0])):
            l[i][j] = (random.randint(0,1))
    while bfs(l,0,0,11,11) != 1:
        for i in range(len(l)):
            for j in range (len(l[0])):
                l[i][j] = (random.randint(0,1))
    l[0][0], l[11][11] = 0, 0
    return

def handleInputStart():
    global text_start
    global color_start
    global active_start
    if event.type == pygame.MOUSEBUTTONDOWN:
            active_start = True if input_start.collidepoint(event.pos) else False
            color_start = color_active if active_start else color_inactive

    if event.type == pygame.KEYDOWN:
        if active_start:
            if event.key == pygame.K_BACKSPACE:
                    text_start = text_start[:-1]
            else:
                    text_start += event.unicode

def handleInputEnd():
    global text_end
    global color_end
    global active_end
    if event.type == pygame.MOUSEBUTTONDOWN:
            active_end = True if input_end.collidepoint(event.pos) else False
            color_end = color_active if active_end else color_inactive

    if event.type == pygame.KEYDOWN:
        if active_end:
            if event.key == pygame.K_BACKSPACE:
                    text_end = text_end[:-1]
            else:
                    text_end += event.unicode

input_start = pygame.Rect(200, 0, 100, 30)
input_end = pygame.Rect(200, 270, 100, 30) 

# Font
font = pygame.font.Font(None, 32)

while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            sys.exit()
        
        handleInputStart()
        handleInputEnd() 
    
    screen.fill(white)     
    button("go", 0, 150, 50, 30, green, bright_green, start)
    button("reset", 450, 150, 50, 30, green, bright_green, reset)

    text_surface = font.render(text_start, True, color_start)
    screen.blit(text_surface, (input_start.x+5, input_start.y+5))
    pygame.draw.rect(screen, color_start, input_start, 3)
    text_surface = font.render(text_end, True, color_end)
    screen.blit(text_surface, (input_end.x+5, input_end.y+5))
    pygame.draw.rect(screen, color_end, input_end, 3) 
    drawMap(l)
    pygame.display.flip()
    clock.tick(10)

