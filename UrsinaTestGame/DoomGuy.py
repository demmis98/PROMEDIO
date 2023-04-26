from ursina import *
class FirstPersonSlayer(Entity):
    def __init__(self, **kargs):
        super().__init__()
        self.speed=5
        self.turnSpeed=10
        self.position=(0,1,0)
        camera.position=self.position
        self.gravity = 1

    def update(self):
        camera.position=self.position
        camera.rotation_y=self.rotation_y
        if self.rotation_y>360:
            self.rotation_y-=360
        if self.rotation_y<-360:
            self.rotation_y+=360
        if held_keys['left arrow']:
            self.rotation_y-=self.turnSpeed
        if held_keys['right arrow']:
            self.rotation_y+=self.turnSpeed
        if held_keys['shift']:
            self.speed=8
        else:
            self.speed=5

        self.direction = Vec3(
            self.forward * (held_keys['up arrow'] - held_keys['down arrow'])
            ).normalized()
        origin = self.world_position + (self.up*.5) + (self.direction/2)
        middle_ray = raycast(origin , self.direction, ignore=[self,], distance=.25, debug=False)
        if not middle_ray.hit:
            self.position += self.direction * self.speed * time.dt