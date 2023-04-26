from ursina import *
from ursina.prefabs.first_person_controller import FirstPersonController


app = Ursina()

class Voxel(Button):
    def __init__(self, position=(0,0,0)):
        super().__init__(
            parent = scene,
            position = position,
            model = 'cube',
            origin_y = .5,
            texture = 'white_cube',
            color = color.color(0, 0, 1),
            highlight_color = color.lime,
        )


    def input(self, key):
        if self.hovered:
            if key == 'left mouse down':
                voxel = Voxel(position=self.position + mouse.normal)

            if key == 'right mouse down':
                destroy(self)


for z in range(20):
    for x in range(20):
        voxel = Voxel(position=(x-10,0,z-10))


player = FirstPersonController()
app.run()
