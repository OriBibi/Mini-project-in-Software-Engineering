package testing;

import elements.*;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.awt.*;

public class RenderTest {

    @Test

    public void basicRendering(){

        Scene scene = new Scene();
       // scene= new Scene("point&vector change",Color.BLACK,
         //       new Camera(new Point3D(0,-80,40),new Vector(1,0,0),new Vector(0,2,-1)),100,new AmbientLight());

        scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150)));

        Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));

        Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),
                new Point3D(  0, -100, -149),
                new Point3D( 100,-100, -149));

        Triangle triangle3 = new Triangle(Color.orange,new Point3D(-100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D(-100, 100, -149));

        Triangle triangle4 = new Triangle(Color.pink,new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter(scene.getSceneName()+ " r1", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        //render.printGrid(50);
        imageWriter.writeToimage();


    }
    @Test

    public void basicRendering2(){

        Scene scene = new Scene();
        // scene= new Scene("point&vector change",Color.BLACK,
        //       new Camera(new Point3D(0,-80,40),new Vector(1,0,0),new Vector(0,2,-1)),100,new AmbientLight());

        scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150)));

        Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));

        Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),
                new Point3D(  0, -100, -149),
                new Point3D( 100,-100, -149));

        Triangle triangle3 = new Triangle(Color.orange,new Point3D(-100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D(-100, 100, -149));

        Triangle triangle4 = new Triangle(Color.pink,new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter(scene.getSceneName()+ " r2", 100, 100, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        //render.printGrid(50);
        imageWriter.writeToimage();


    }
    public void SameTestAsPart6() {
        Scene scene = new Scene();

        scene.addGeometry(new Sphere(Color.blue, 50, new Point3D(0.0, 0.0, -150)));

        Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));

        Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),
                new Point3D(  0, -100, -149),
                new Point3D( 100,-100, -149));

        Triangle triangle3 = new Triangle(Color.orange,new Point3D(-100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D(-100, 100, -149));

        Triangle triangle4 = new Triangle(Color.pink,new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        //render.printGrid(50);
        imageWriter.writeToimage();



    }

    @Test
    public void testAddingLightSources(){

        PointLight pl = new PointLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100),
                0, 0.000001, 0.0000005));
        SpotLight sl = new SpotLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                new Vector(), 0, 0.00001, 0.000005));

        DirectionalLight dl = new DirectionalLight(new Color(255, 100, 100),new Vector());

    }

    @Test
    public void pointLightTest1(){

        Scene scene = new Scene();
        scene.setScreenDistance(100);
        Sphere sphere = new Sphere (new Color(0, 0, 100),800, new Point3D(0,0,-1000));
        Material m=new Material();
        m.setnShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(57, 93, 255), new Point3D(-200, -200,-100),//-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point Test1", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        ////render.printGrid(50);
        imageWriter.writeToimage();

    }


    @Test
    public void pointLightTest2(){
        Scene scene = new Scene();
        scene.setScreenDistance(100);
        Sphere sphere = new Sphere (new Color(0,0,100),800, new Point3D(0,0, -1000));
        Material m=new Material();
        m.setnShininess(20);
        sphere.setMaterial(m);


        Triangle triangle = new Triangle(new Color(0,0,0), new Point3D(  3500, 3500, -2000),
                new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000) );
        Triangle triangle2 = new Triangle(new Color(0,0,0), new Point3D(   3500, 3500, -2000),
                new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200,200, -100),
                0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point Test2", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);

        render.renderImage();
        ////render.printGrid(50);
        imageWriter.writeToimage();
    }



    @Test
    public void spotLightTest1(){

        Scene scene = new Scene();
        scene.setScreenDistance(100);
        Sphere sphere = new Sphere (new Color(0,0,100),800, new Point3D(0,0, -1000));


        Material m=new Material();
        m.setnShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                new Vector(2, 2, -3),0, 0.00001, 0.000005 ));

        ImageWriter imageWriter = new ImageWriter("Spot Test1", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        ////render.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);

        Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));

        Material m=new Material();
        m.setnShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Color (0, 0, 100),
                new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270)
        );

        Material m1=new Material();
        m1.setnShininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3),0.1, 0.00001, 0.000005 ));

        ImageWriter imageWriter = new ImageWriter("Spot Test2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        ////render.printGrid(50);
        imageWriter.writeToimage();
    }

    @Test
    public void spotLightTest3(){


        Scene scene = new Scene();
        scene.setScreenDistance(100);

        Triangle triangle = new Triangle(new Color(0,0,0),
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000)
        );



        Triangle triangle2 = new Triangle(new Color(0,0,0),
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000)
        );

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3),0, 0.000001, 0.0000005 ));


        ImageWriter imageWriter = new ImageWriter("Spot Test3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        //render.printGrid(50);
        imageWriter.writeToimage();

    }

}