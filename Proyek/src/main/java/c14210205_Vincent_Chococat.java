//c14210205_Vincent_Chococat
import Engine.*;
import Engine.Object;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;

public class c14210205_Vincent_Chococat {
    static float yBadan=0f;
    static boolean HeadTurnX=true;
    static float HeadDegX=0f;
    static boolean HeadTurnY=true;
    static float HeadDegY=0f;
    static boolean BodyTurn=true;
    static float BodyDeg=0f;
    static boolean EyeTurnX=true;
    static float EyeDegX=0f;
    static boolean EyeTurnY=true;
    static float EyeDegY=0f;
    static boolean LegTurn=true;
    static float LegDeg=0f;
    static boolean HandTurnX=true;
    static float HandDegX=0f;
    static boolean HandTurnY=true;
    static float HandDegY=0f;
    float walkDeg =45f;
    int direction = 1;
    private Window window =
            new Window
                    (800,800,"Hello");
    private ArrayList<Object> objects
            = new ArrayList<>();

    private MouseInput mouseInput;
    int countDegree = 0;
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    Camera camera = new Camera();
    public void init() {
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        camera.setPosition(0, 0, 1f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));

        //Head
        {
            objects.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(0).scaleObject(1f, 0.85f, 0.75f);
//        objects.get(0).rotateObject((float)Math.toRadians(90f),1f,0f,0f);
            objects.get(0).getChildObject().add(new Cone(//right ear
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(0).getChildObject().get(0).scaleObject(0.012f, 0.005f, 0.0025f);
            objects.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-38f), 0f, 0f, 1f);
            objects.get(0).getChildObject().get(0).translateObject(0.12f, 0.12f, 0.0f);

            objects.get(0).getChildObject().add(new Cone(//left ear
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(1.0f, 1.0f, 1.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(0).getChildObject().get(1).scaleObject(0.012f, 0.005f, 0.0025f);
            objects.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(95f), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(38f), 0f, 0f, 1f);
            objects.get(0).getChildObject().get(1).translateObject(-0.12f, 0.12f, 0.0f);

            objects.get(0).getChildObject().add(new Cone(//inner right ear
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(0).getChildObject().get(2).scaleObject(0.007f, 0.007f, 0.002f);
            objects.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-38f), 0f, 0f, 1f);
            objects.get(0).getChildObject().get(2).translateObject(0.1f, 0.099f, 0.005f);

            objects.get(0).getChildObject().add(new Cone(//inner left ear
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(1.0f, 1.0f, 1.0f),
                    0.125f,
                    0.125f
            ));
            objects.get(0).getChildObject().get(3).scaleObject(0.007f, 0.007f, 0.002f);
            objects.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(95f), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(38f), 0f, 0f, 1f);
            objects.get(0).getChildObject().get(3).translateObject(-0.1f, 0.099f, 0.005f);

            objects.get(0).getChildObject().add(new Sphere( //nose
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.3f, 0.1f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(0).getChildObject().get(4).scaleObject(0.07f, 0.05f, 0.075f);
            objects.get(0).getChildObject().get(4).translateObject(0.0f, -0.02f, 0.1f);

            objects.get(0).getChildObject().add(new Sphere( //right eye
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(0).getChildObject().get(5).scaleObject(0.2f, 0.2f, 0.075f);
            objects.get(0).getChildObject().get(5).translateObject(0.033f, 0.02f, 0.09f);

            objects.get(0).getChildObject().add(new Sphere( //left eye
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(0).getChildObject().get(6).scaleObject(0.2f, 0.2f, 0.075f);
            objects.get(0).getChildObject().get(6).translateObject(-0.033f, 0.02f, 0.09f);

            objects.get(0).getChildObject().add(new Sphere( //right pupil
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(0).getChildObject().get(7).scaleObject(0.07f, 0.07f, 0.05f);
            objects.get(0).getChildObject().get(7).translateObject(0.025f, 0.015f, 0.1f);

            objects.get(0).getChildObject().add(new Sphere( //left pupil
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(0).getChildObject().get(8).scaleObject(0.07f, 0.07f, 0.05f);
            objects.get(0).getChildObject().get(8).translateObject(-0.025f, 0.015f, 0.1f);

            objects.get(0).getChildObject().add(new Kotak( //left mustache 1
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    360,
                    18
            ));
            objects.get(0).getChildObject().get(9).scaleObject(0.7f, 0.05f, 0.05f);
            objects.get(0).getChildObject().get(9).translateObject(-0.13f, 0.015f, 0.06f);
            objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 0f, 1f);

            objects.get(0).getChildObject().add(new Kotak( //left mustache 2
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    360,
                    18
            ));
            objects.get(0).getChildObject().get(10).scaleObject(0.7f, 0.05f, 0.05f);
            objects.get(0).getChildObject().get(10).translateObject(-0.13f, 0.01f, 0.06f);
            objects.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(0f), 0f, 0f, 1f);

            objects.get(0).getChildObject().add(new Kotak( //right mustache 1
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    360,
                    18
            ));
            objects.get(0).getChildObject().get(11).scaleObject(0.7f, 0.05f, 0.05f);
            objects.get(0).getChildObject().get(11).translateObject(0.13f, 0.015f, 0.06f);
            objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);

            objects.get(0).getChildObject().add(new Kotak( //right mustache 2
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    360,
                    18
            ));
            objects.get(0).getChildObject().get(12).scaleObject(0.7f, 0.05f, 0.05f);
            objects.get(0).getChildObject().get(12).translateObject(0.13f, 0.01f, 0.06f);
            objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(0f), 0f, 0f, 1f);
        }
        //Body
        {
            objects.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(1).scaleObject(0.6f, 0.75f, 0.5f);
            objects.get(1).translateObject(0.0f, -0.14f, 0.0f);

            objects.get(1).getChildObject().add(new HalfSpheare( //Collar
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(1).getChildObject().get(0).scaleObject(0.55f, 0.07f, 0.3f);
            objects.get(1).getChildObject().get(0).translateObject(0.0f, -0.09f, 0.02f);
            objects.get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(0f), 1f, 0f, 0f);

            objects.get(1).getChildObject().add(new Sphere( //Right Hand
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(1).getChildObject().get(1).scaleObject(0.5f, 0.2f, 0.2f);
            objects.get(1).getChildObject().get(1).translateObject(0.06f, -0.12f, 0.0f);
            objects.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(20f), 0f, 0f, 1f);

            objects.get(1).getChildObject().add(new Sphere( //Left Hand
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(1).getChildObject().get(2).scaleObject(0.5f, 0.2f, 0.2f);
            objects.get(1).getChildObject().get(2).translateObject(-0.06f, -0.12f, 0.0f);
            objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-20f), 0f, 0f, 1f);

            objects.get(1).getChildObject().add(new Sphere( //Left Foot
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(1).getChildObject().get(3).scaleObject(0.2f, 0.4f, 0.2f);
            objects.get(1).getChildObject().get(3).translateObject(-0.035f, -0.23f, 0.0f);
//            objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(40f), 0f, 0f, 1f);

            objects.get(1).getChildObject().add(new Sphere( //Right Foot
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.125f,
                    0.125f,
                    0.125f,
                    36,
                    1000
            ));
            objects.get(1).getChildObject().get(4).scaleObject(0.2f, 0.4f, 0.2f);
            objects.get(1).getChildObject().get(4).translateObject(0.035f, -0.23f, 0.0f);
//            objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-40f), 0f, 0f, 1f);
            objects.get(1).getChildObject().add(new Tail( Arrays.asList(
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
            ),
                    new ArrayList<>(),
                    new Vector4f(0f,0f,0f,1.0f),
                    Arrays.asList(
                            new float[]{0.0f, 0.0f,0},
                            new float[]{0.01f, -0.01f,0},
                            new float[]{0.03f, 0.03f,0},
                            new float[]{0.05f, -0.01f, 0},
                            new float[]{0.055f, 0.01f, 0},
                            new float[]{0.06f,0.01f,0},
                            new float[]{0.10f,0.01f,0},
                            new float[]{0.11f,0.01f,0},
                            new float[]{0.12f,-0.11f,0},
                            new float[]{0.2f,-0.11f,0}
                            )
                    ));
            objects.get(1).getChildObject().get(5).translateObject(0.0f, 0.2f, 0.0f);
            objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(180f), 0f, 0f, 1f);
            objects.get(1).getChildObject().get(5).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0f);


        }
    }
    public void input(){
        if (window.isKeyPressed(GLFW_KEY_Q)) { //Kepala Kiri
            countDegree++;
            if (HeadDegX<=-35f)
                setHeadTurnX(false);
            else
                setHeadTurnX(true);
            if(HeadTurnX){
                objects.get(0).rotateObject((float)Math.toRadians(-0.5f),0f,1f,0f);
                setHeadDegX(-0.5f);
            }

            if (EyeDegX<=-5f)
                setEyeTurnX(false);
            else
                setEyeTurnX(true);
            if(EyeTurnX){
                objects.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(-0.1f),0f,1f,0f);
                objects.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(-0.1f),0f,1f,0f);
                setEyeDegX(-0.1f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_E)) { //Kepala Kanan
            countDegree++;
            if (HeadDegX>=35f)
                setHeadTurnX(false);
            else
                setHeadTurnX(true);
            if(HeadTurnX){
                objects.get(0).rotateObject((float)Math.toRadians(0.5f),0f,1f,0f);
                setHeadDegX(0.5f);
            }

            if (EyeDegX>=5f)
                setEyeTurnX(false);
            else
                setEyeTurnX(true);
            if(EyeTurnX){
                objects.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(0.1f),0f,1f,0f);
                objects.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(0.1f),0f,1f,0f);
                setEyeDegX(0.1f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_F)) { //Kepala Atas
            countDegree++;
            if (HeadDegY>=20f)
                setHeadTurnY(false);
            else
                setHeadTurnY(true);
            if(HeadTurnY){
                objects.get(0).rotateObject((float)Math.toRadians(0.5f),1f,0f,0f);
                setHeadDegY(0.5f);
            }

            if (EyeDegY>=5f)
                setEyeTurnY(false);
            else
                setEyeTurnY(true);
            if(EyeTurnY){
                objects.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(0.2f),1f,0f,0f);
                objects.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(0.2f),1f,0f,0f);
                setEyeDegY(0.2f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_R)) { //Kepala Bawah
            countDegree++;
            if (HeadDegY<=-90f)
                setHeadTurnY(false);
            else
                setHeadTurnY(true);
            if(HeadTurnY){
                objects.get(0).rotateObject((float)Math.toRadians(-0.5f),1f,0f,0f);
                setHeadDegY(-0.5f);
            }

            if (EyeDegY<=-5f)
                setEyeTurnY(false);
            else
                setEyeTurnY(true);
            if(EyeTurnY){
                objects.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(-0.2f),1f,0f,0f);
                objects.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(-0.2f),1f,0f,0f);
                setEyeDegY(-0.2f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_C)) { //Rotasi Kanan
            countDegree++;
            objects.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objects.get(1).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            setyBadan(0.5f);
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) { //Rotasi Kiri
            countDegree++;
            objects.get(0).rotateObject((float) Math.toRadians(-0.5f),0.0f,1.0f,0.0f);
            objects.get(1).rotateObject((float) Math.toRadians(-0.5f),0.0f,1.0f,0.0f);
            setyBadan(-0.5f);
        }
        if (window.isKeyPressed(GLFW_KEY_O)) { //Translasi Kanan
            objects.get(0).translateObject(0.001f,0.0f,0.0f);
            objects.get(1).translateObject(0.001f,0.0f,0.00f);
        }
        if (window.isKeyPressed(GLFW_KEY_I)) { //Translasi Kiri
            objects.get(0).translateObject(-0.001f,0.0f,0.0f);
            objects.get(1).translateObject(-0.001f,0.0f,0.00f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) { //Badan Kanan
            countDegree++;
            if (BodyDeg>=35f)
                setBodyTurn(false);
            else
                setBodyTurn(true);
            if(BodyTurn){
                objects.get(1).rotateObject((float)Math.toRadians(0.5f),0f,1f,0f);
                setBodyDeg(0.5f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_A)) { //Badan Kiri
            countDegree++;
            if (BodyDeg<=-35f)
                setBodyTurn(false);
            else
                setBodyTurn(true);
            if(BodyTurn){
                objects.get(1).rotateObject((float)Math.toRadians(-0.5f),0f,1f,0f);
                setBodyDeg(-0.5f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) { //Tangan Atas
            countDegree++;
            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            if (HandDegY == 0f)
                setHandTurnY(false);
            else
                setHandTurnY(true);
            if(HandTurnY){
                List<Float> tangan = new ArrayList<>(objects.get(1).getCenterPoint());
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);

                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 0.0f, 1.0f);
                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);
                setHandDegY(-0.5f);
            }

            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }

        if (window.isKeyPressed(GLFW_KEY_S)) { //Tangan Bawah
            countDegree++;
            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            if (HandDegY >= 20f)
                setHandTurnY(false);
            else
                setHandTurnY(true);
            if(HandTurnY){
                List<Float> tangan = new ArrayList<>(objects.get(1).getCenterPoint());
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 0.0f, 1.0f);
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);

                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);
                setHandDegY(+0.5f);
            }


            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }


        if (window.isKeyPressed(GLFW_KEY_V)) { //Tangan Tutup
            countDegree++;
            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            if (HandDegX >= 80f)
                setHandTurnX(false);
            else
                setHandTurnX(true);
            if(HandTurnX){
                List<Float> tangan = new ArrayList<>(objects.get(1).getCenterPoint());
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 1.0f, 0.0f);
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);

                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);
                setHandDegX(+0.5f);
            }


            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }

        if (window.isKeyPressed(GLFW_KEY_B)) { //Tangan Buka
            countDegree++;
            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            if (HandDegX == 0f)
                setHandTurnX(false);
            else
                setHandTurnX(true);
            if(HandTurnX){
                List<Float> tangan = new ArrayList<>(objects.get(1).getCenterPoint());
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
                objects.get(1).getChildObject().get(1).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);

                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * -1, tangan.get(1) * -1, tangan.get(2) * -1);
                objects.get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 1.0f, 0.0f);
                objects.get(1).getChildObject().get(2).translateObject(tangan.get(0) * 1, tangan.get(1) * 1, tangan.get(2) * 1);
                setHandDegX(-0.5f);
            }



            objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }

        if (window.isKeyPressed(GLFW_KEY_G)) { //Kaki Mundur
            countDegree++;
            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            if (LegDeg == 0f)
                setLegTurn(false);
            else
                setLegTurn(true);
            if(LegTurn){
                List<Float> kaki = new ArrayList<>(objects.get(1).getCenterPoint());
                objects.get(1).getChildObject().get(3).translateObject(kaki.get(0) * -1, kaki.get(1) * -1, kaki.get(2) * -1);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objects.get(1).getChildObject().get(3).translateObject(kaki.get(0) * 1, kaki.get(1) * 1, kaki.get(2) * 1);

                objects.get(1).getChildObject().get(4).translateObject(kaki.get(0) * -1, kaki.get(1) * -1, kaki.get(2) * -1);
                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
                objects.get(1).getChildObject().get(4).translateObject(kaki.get(0) * 1, kaki.get(1) * 1, kaki.get(2) * 1);
                setLegDeg(+0.5f);
            }



            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_T)) { //Kaki Maju
            countDegree++;
            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            if (LegDeg<=-60f)
                setLegTurn(false);
            else
                setLegTurn(true);
            if(LegTurn){
                List<Float> kaki = new ArrayList<>(objects.get(1).getCenterPoint());
                objects.get(1).getChildObject().get(3).translateObject(kaki.get(0) * -1, kaki.get(1) * -1, kaki.get(2) * -1);
                objects.get(1).getChildObject().get(3).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                objects.get(1).getChildObject().get(3).translateObject(kaki.get(0) * 1, kaki.get(1) * 1, kaki.get(2) * 1);

                objects.get(1).getChildObject().get(4).translateObject(kaki.get(0) * -1, kaki.get(1) * -1, kaki.get(2) * -1);
                objects.get(1).getChildObject().get(4).rotateObject((float) Math.toRadians(-0.5f), 1.0f, 0.0f, 0.0f);
                objects.get(1).getChildObject().get(4).translateObject(kaki.get(0) * 1, kaki.get(1) * 1, kaki.get(2) * 1);
                setLegDeg(-0.5f);
            }


            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_X)) { //Rotate Keatas
            objects.get(0).rotateObject((float)Math.toRadians(0.5f),1f,0f,0f);
            objects.get(1).rotateObject((float)Math.toRadians(0.5f),1f,0f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_Y)) { //Rotate Kebawah
            objects.get(0).rotateObject((float)Math.toRadians(-0.5f),1f,0f,0f);
            objects.get(1).rotateObject((float)Math.toRadians(-0.5f),1f,0f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_L)) { //Scale Kecil
            objects.get(0).scaleObject(0.99f, 0.99f, 0.99f);
            objects.get(1).scaleObject(0.99f, 0.99f, 0.99f);
        }
        if (window.isKeyPressed(GLFW_KEY_P)) { //Scale Besar
            objects.get(0).scaleObject(1.01f, 1.01f, 1.01f);
            objects.get(1).scaleObject(1.01f, 1.01f, 1.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_J)){ //Karakter Berjalan
            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(0).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);
            objects.get(1).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            float degree = 0.15f;
            if (walkDeg >= 15f){
                direction *= -1;
                walkDeg = 0;
            }
            objects.get(0).rotateObject((float)Math.toRadians(-yBadan),0f,1f,0f);

            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(direction *degree),1f,0f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(direction *-degree),1f,0f,0f);
            objects.get(0).translateObject(0.0f, 0.0f, 0.001f);
            objects.get(1).translateObject(0.0f, 0.0f, 0.001f);

            objects.get(0).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            walkDeg +=degree;

            objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).getChildObject().get(4).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(0).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
            objects.get(1).rotateObject((float)Math.toRadians(yBadan),0f,1f,0f);
        }
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.6f,
                    0.6f, 0.6f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code

            for(Object object: objects){
                object.draw(camera,projection);
            }
//            for(Object object: objectsRectangle){
//                object.draw();
//            }
//            for(Object object: objectsPointsControl){
//                object.drawLine();
//            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new c14210205_Vincent_Chococat().run();
    }
    public static void setyBadan(float yBadan) {
        c14210205_Vincent_Chococat.yBadan += yBadan;
    }
    public static void setHeadTurnX(boolean headTurnX) {
        c14210205_Vincent_Chococat.HeadTurnX = headTurnX;
    }
    public static void setHeadDegX(float headDegX) {
        c14210205_Vincent_Chococat.HeadDegX += headDegX;
    }
    public static void setHeadTurnY(boolean headTurnY) {
        c14210205_Vincent_Chococat.HeadTurnY = headTurnY;
    }
    public static void setHeadDegY(float headDegY) {
        c14210205_Vincent_Chococat.HeadDegY += headDegY;
    }
    public static void setEyeTurnX(boolean eyeTurnX) {
        c14210205_Vincent_Chococat.EyeTurnX = eyeTurnX;
    }
    public static void setEyeDegX(float eyeDegX) {
        c14210205_Vincent_Chococat.EyeDegX += eyeDegX;
    }
    public static void setEyeTurnY(boolean eyeTurnY) {
        c14210205_Vincent_Chococat.EyeTurnY = eyeTurnY;
    }
    public static void setEyeDegY(float eyeDegY) {
        c14210205_Vincent_Chococat.EyeDegY += eyeDegY;
    }
    public static void setBodyTurn(boolean bodyTurn) {
        c14210205_Vincent_Chococat.BodyTurn = bodyTurn;
    }
    public static void setBodyDeg(float bodyDeg) {
        c14210205_Vincent_Chococat.BodyDeg += bodyDeg;
    }
    public static void setLegTurn(boolean legTurn) {
        c14210205_Vincent_Chococat.LegTurn = legTurn;
    }
    public static void setLegDeg(float legDeg) {
        c14210205_Vincent_Chococat.LegDeg += legDeg;
    }
    public static void setHandTurnX(boolean handTurnX) {
        c14210205_Vincent_Chococat.HandTurnX = handTurnX;
    }
    public static void setHandDegX(float handDegX) {
        c14210205_Vincent_Chococat.HandDegX += handDegX;
    }
    public static void setHandTurnY(boolean handTurnY) {
        c14210205_Vincent_Chococat.HandTurnY = handTurnY;
    }
    public static void setHandDegY(float handDegY) {
        c14210205_Vincent_Chococat.HandDegY += handDegY;
    }

}
