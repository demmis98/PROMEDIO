from ursina import *
from ursina.mesh_importer import load_model
def LoadMap():
    class Stone(Button):
        def __init__(self, position=(0,0,0)):
            super().__init__(
                parent = scene,
                position = position,
                model = 'cube',
                origin_y = .5,
                texture = 'Stone_texture',
                color = color.color(0, 0, 1),
                highlight_color = color.lime,
            )
    class WeirdThing(Button):
        def __init__(self, position=(0,0,0)):
            super().__init__(
                parent = scene,
                position = position,
                model ='cube',
                origin_y = .5,
                texture = 'Stone_texture',
                color = color.color(0, 0, 1),
                highlight_color = color.lime,
            )
    for z in range(20):
        for x in range(20):
            for y in range(1):
                stone = Stone(position=(x-10,y,z-10))
    weirdThing = WeirdThing(position=(0,1,4))