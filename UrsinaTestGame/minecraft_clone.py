from ursina import *
from ursina.prefabs.first_person_controller import FirstPersonController

app = Ursina()
selectedCube=0
cubeColor=color.gray

def update():
    if held_keys['z']:
        if selectedCube>0:
            selectedCube-=1
    if held_keys['x']:
        if selectedCube<20:
            selectedCube+=1
class Stone(Button):
    def __init__(self, position=(0,0,0)):
        super().__init__(
            parent = scene,
            position = position,
            model = 'cube',
            origin_y = .5,
            texture = 'Stone_texture',
            color = cubeColor,
            highlight_color = color.white,
        )


    def input(self, key):
        if self.hovered:
            if key == 'left mouse down':
                if selectedCube==0:
                    stone = Stone(position=self.position + mouse.normal)

            if key == 'right mouse down':
                destroy(self)
class StoneBlack(Button):
    def __init__(self, position=(0,0,0)):
        super().__init__(
            parent = scene,
            position = position,
            model = 'cube',
            origin_y = .5,
            texture = 'Stone_texture',
            color = cubeColor,
            highlight_color = color.white,
        )


    def input(self, key):
        if self.hovered:
            BlockManager()

def BlockManager():
        if key == 'left mouse down':
          if selectedCube==0:
            stone = Stone(position=self.position + mouse.normal)
        if key == 'right mouse down':
            destroy(self)

for z in range(20):
    for x in range(20):
        stone = Stone(position=(x-10,0,z-10))



player = FirstPersonController()
app.run()