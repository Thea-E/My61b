public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	static final double G=6.67e-11;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
	xxPos=xP;
	yyPos=yP;
	xxVel=xV;
	yyVel=yV;
	mass=m;
	imgFileName=img;
	}
	public Planet (Planet p){
	xxPos=p.xxPos;
	yyPos=p.yyPos;
	xxVel=p.xxVel;
	yyVel=p.yyVel;
	mass=p.mass;
	imgFileName=p.imgFileName;
	}
	public Planet(){
        this.xxPos = 0;
        this.yyPos = 0;
        this.xxVel = 0;
        this.yyVel = 0;
        this.mass = 0;
        this.imgFileName = "";
    }

/* calculate distance between 2 planets.  **/
public double calcDistance(Planet makabaka){
	double distance=(this.xxPos-makabaka.xxPos)*(this.xxPos-makabaka.xxPos)+(this.yyPos-makabaka.yyPos)*(this.yyPos-makabaka.yyPos);
	return Math.sqrt(distance);
}

/* Force */

/* total force exerted by other planet**/
public double calcForceExertedBy(Planet makabaka){
	double rr=this.calcDistance(makabaka)*this.calcDistance(makabaka);
	double F=G*this.mass*makabaka.mass/rr;
	return F;
}

/* force in X/Y direction exerted by other planet**/
public double calcForceExertedByX(Planet makabaka){
	double dx=makabaka.xxPos-this.xxPos;
	return this.calcForceExertedBy(makabaka)/this.calcDistance(makabaka)*dx;
}
public double calcForceExertedByY(Planet makabaka){
	double dy=makabaka.yyPos-this.yyPos;
	return this.calcForceExertedBy(makabaka)/this.calcDistance(makabaka)*dy;
}

/* force added in x,y direction**/
public double calcNetForceExertedByX (Planet[] wulala){
	double xF=0;
	for (Planet p:wulala){
		if(!this.equals(p)) {
			xF=xF+this.calcForceExertedByX(p);
		}
	}
	return xF;
}
public double calcNetForceExertedByY (Planet[] wulala){
	double yF=0;
	for (Planet p:wulala){
		if(!this.equals(p)) {
			yF=yF+this.calcForceExertedByY(p);
		}
	}
	return yF;
}

/*update the status when time passed**/
public void update(double dt,double fX,double fY){
	double ax=fX/this.mass;
	double ay=fY/this.mass;
	this.xxVel=this.xxVel+ax*dt;
	this.yyVel=this.yyVel+ay*dt;
	this.xxPos=this.xxPos+this.xxVel*dt;
	this.yyPos=this.yyPos+this.yyVel*dt;
}

/* Draw 1 planet**/
public void draw(){
 StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
}



}