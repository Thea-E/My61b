public class NBody {

    private static String starField = "./images/starfield.jpg";

    public static double readRadius(String path){
        In in = new In(path);
        in.readDouble();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int universeSize = in.readInt();
        Planet[] planets = new Planet[universeSize];
        for(int j = 0; j < universeSize; j++){
            planets[j] = new Planet();
        }
        in.readDouble();
        int i = 0;
        while(!in.isEmpty()){
            if(i == universeSize) break;
            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass = in.readDouble();
            planets[i].imgFileName = in.readString();
            i += 1;
        }
        return planets;
    }

/*FINALLY HERE COMES THE MAIN METHOD!!!!**/
public static void main(String[] args){
    
    double T=Double.parseDouble (args[0]);
    double dt=Double.parseDouble (args[1]);
    String filename = args[2];

    double radius=readRadius(filename);
    Planet[] planets=readPlanets(filename);

    StdDraw.setScale(-radius,radius);
    StdDraw.picture(0,0,"images/starfield.jpg");

/* Draw Planetssss **/
    for (Planet p:planets){
        p.draw();
    }

    StdDraw.enableDoubleBuffering();
    double littletime;
    for (littletime=0;littletime<T; littletime=littletime+dt){
        double[] xForces= new double [planets.length];
        double[] yForces= new double [planets.length];

        for(int r=0; r<planets.length;r++){                         /* Calculate the net x and y forces for each planet**/
             xForces[r]=planets[r].calcNetForceExertedByX(planets);
             yForces[r]=planets[r].calcNetForceExertedByY(planets);
        }
        for(int r=0; r<planets.length;r++){    
             planets[r].update(dt, xForces[r],yForces[r]);
             /* Draw Planetssss **/
            for (Planet p:planets){
              p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
       

    }
    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
for (int i = 0; i < planets.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

}


}
