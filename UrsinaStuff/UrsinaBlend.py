from ursina import *
from ursina.mesh_importer import *
app = Ursina()
class Voxel(Button):
    def __init__(self, position=(0,0,0)):
        super().__init__(
            parent = scene,
            position = position,
            model = 'WeirdThing',
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

voxel = Voxel(position=(0,0,0))
def update():
    if held_keys['w']:
        voxel.rotation_y+=10
    if held_keys['s']:
        voxel.rotation_x+=10
app.run()