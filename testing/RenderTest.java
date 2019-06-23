
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

import java.util.ArrayList;
import java.util.Random;

import java.awt.*;
import java.util.List;

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
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200,-100),//-200, -200, -100),
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
        scene.addGeometry(sphere);
        sphere.setMaterial(m);
        Triangle triangle = new Triangle(new Color(0,0,0), new Point3D(  3500, 3500, -2000),
                new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000) );
        Triangle triangle2 = new Triangle(new Color(0,0,0), new Point3D(   3500, 3500, -2000),
                new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000));
        m.setKr(1);
        m.setKt(1);
        triangle.setMaterial(m);
        m.setKr(0);
        m.setKt(0);
        triangle2.setMaterial(m);
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
   public void pointLightTest7(){
       Scene scene = new Scene();
       scene.setScreenDistance(100);
       Sphere sphere = new Sphere (new Color(0,0,100),new Material(0.5, 0.5, 80,0,0.9),400, new Point3D(0,0, -1000));
       Material m=new Material();
       scene.addLight(new DirectionalLight(new Color(80, 80, 80),new Vector(-1,1,-1)));
       m.setnShininess(20);
       sphere.setMaterial(m);
       Triangle triangle = new Triangle(new Color(0,0,0), new Point3D(  3500, 3500, -2000),
               new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000) );
       Triangle triangle2 = new Triangle(new Color(0,0,0), new Point3D(   3500, 3500, -2000),
               new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000));
       m.setKr(1);
       m.setKt(1);
       triangle.setMaterial(m);
       m.setKr(0);
       m.setKt(0);
       scene.addGeometry(sphere);
       triangle2.setMaterial(m);
       scene.addGeometry(triangle);
       scene.addGeometry(triangle2);
      // scene.addLight(new PointLight(new Color(255,100,100), new Point3D(200,200, 100),
       //        0, 0.00001, 0.000005));
       ImageWriter imageWriter = new ImageWriter("Point Test2", 500, 500, 500, 500);
       Render render = new Render(scene, imageWriter);

       render.renderImage();
       ////render.printGrid(50);
       imageWriter.writeToimage();
   }
  /*  @Test
    public void proTests(){
        Scene scene = new Scene();
        scene.setCamera(new Camera(new Point3D(-800,-200,0),new Vector(0,-1,0),new Vector(1,0,0), new Vector(0,0,-1)));
        scene.setScreenDistance(200);
        scene.setBackGround(Color.BLACK);
        scene.addLight(new PointLight(new Color(50, 100, 100), new Point3D(-700, -200,-300),
                0, 0.000001, 0.0000005));
        scene.setAmbientLight(new AmbientLight(new Color(20, 20, 20),1));
       // scene.addLight(new SpotLight(new Color(50, 100, 100), new Point3D(-700, 200, 600),
        //        new Vector(-2, -2, -3),0, 0.000001, 0.0000005 ));
        //scene.addLight(new DirectionalLight(new Color(20,20,20),new Vector(-1,1,-1)));
        scene.addGeometry(new Triangle(new Material(0.5,0.5,100,1,0),new Color(20,20,20),new Point3D(600,400,-400),new Point3D(-1400,400,-400),new Point3D(600,-600,-2320)));
        scene.addGeometry(new Triangle(new Material(0.5,0.5,100,1,0),new Color(20,20,20),new Point3D(-1400,400,-400),new Point3D(600,-600,-2320),new Point3D(-1400,-600,-2320)));
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                if((j+i)%2==0) {
                    Sphere sphere = new Sphere(new Color((int) (Math.random() * 250), (int) (Math.random() * 250), (int) (Math.random() * 250)), new Material(0.5, 0.5, 100), 100, new Point3D(500 - i * 200*2, -(100 + j * 100) + 400, -(500 + j * 180) + 100));
                    scene.addGeometry(sphere);

                }
                else {
                    Sphere sphere = new Sphere(new Color((int) (Math.random() * 250), (int) (Math.random() * 250), (int) (Math.random() * 250)), new Material(0.5, 0.5, 30,0,0.5), 100, new Point3D(500 - i * 200*2, -(100 + j * 100) + 400, -(500 + j * 180) + 100));
                    Sphere sphere2 = new Sphere(new Color((int) (Math.random() * 250), (int) (Math.random() * 250), (int) (Math.random() * 250)), new Material(0.5, 0.5, 30), 50, new Point3D(500 - i * 200*2, -(100 + j * 100) + 400, -(500 + j * 180) + 100));
                    scene.addGeometry(sphere);
                    scene.addGeometry(sphere2);

                }
            }
        }
        ImageWriter imw = new ImageWriter("IMG_0021_Balls",500,500,500,300);
        Render rn = new Render(scene,imw);
        rn.renderImage();
        imw.writeToimage();

    }*/


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
    @Test
    public void testShadow(){

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
                new Vector(2, 2, -3),  0.1, 0.00001, 0.000005));


        ImageWriter imageWriter = new ImageWriter("Shadow Test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();
    }
    @Test
    public void recursiveTest1(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.getMaterial().setnShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.getMaterial().setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.getMaterial().setnShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.getMaterial().setKt(0);
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.2   , 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);

        Render render = new Render( scene,imageWriter);

        render.renderImage();
        imageWriter.writeToimage();
    }
    @Test
    public void recursiveTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere( new Color(0,0,100), 300, new Point3D(-550, -500, -1000));

        sphere.getMaterial().setnShininess(20);



        sphere.getMaterial().setKt(0.5);

        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20), 150, new Point3D(-550, -500, -1000));
        sphere2.getMaterial().setnShininess(20);



        sphere2.getMaterial().setKt(0);
        sphere2.getMaterial().setKr(0);





        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));


        triangle.getMaterial().setKr(1);
        triangle2.getMaterial().setKr(0.5);


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);


        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0.1, 0.00001, 0.000005));




        ImageWriter imageWriter = new ImageWriter("65Recursive Test 2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void recursiveTest3(){

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(new Color(0, 0, 100), 300, new Point3D(0, 0, -1000));
        Material sphere1Mat = new Material();
        sphere1Mat.setKt(0.5);
        sphere1Mat.setnShininess(20);
        sphere.setMaterial(sphere1Mat);



        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(new Color(100, 20, 20), 150, new Point3D(0, 0, -1000));


        Material sphereMat = new Material();
        sphereMat.setKt(0);
        sphereMat.setnShininess(20);
        sphere2.setMaterial(sphereMat);

        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Color(20, 20, 20),
                new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        Material m1 = new Material();
        Material m2 = new Material();
        m1.setKr(1);
        m2.setKr(0.5);
        triangle.setMaterial(m1);
        triangle2.setMaterial(m2);


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        imageWriter.writeToimage();

    }
}