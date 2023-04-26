from ursina import *                    # Import the ursina engine
from DoomGuy import FirstPersonSlayer
from DoomMap1 import LoadMap
from ursina.mesh_importer import load_model
app = Ursina()                          # Initialise your Ursina app
selectedCube = 0


window.title = 'My Game'                # The window title
window.borderless = False               # Show a border
window.fullscreen = False               # Do not go Fullscreen
window.exit_button.visible = False      # Do not show the in-game red X that loses the window
window.fps_counter.enabled = True       # Show the FPS (Frames per second) counter
TheWorld = LoadMap()
player = FirstPersonSlayer()
app.run()                               # Run the app