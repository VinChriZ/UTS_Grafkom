package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Cone extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;
    public Cone(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
//        createBox();
        createSphere();
        setupVAOVBO();
    }
    public void createSphere(){
//        float pi = (float)Math.PI;
//
//        float sectorStep = 2 * (float)Math.PI / sectorCount;
//        float stackStep = (float)Math.PI / stackCount;
//        float sectorAngle, StackAngle, x, y, z;
//
//        for (int i = 0; i <= stackCount; ++i)
//        {
//            StackAngle = pi / 2 - i * stackStep;
//            x = radiusX * (float)Math.cos(StackAngle);
//            y = radiusY * (float)Math.cos(StackAngle);
//            z = radiusZ * (float)Math.sin(StackAngle);
//
//            for (int j = 0; j <= sectorCount; ++j)
//            {
//                sectorAngle = j * sectorStep;
//                Vector3f temp_vector = new Vector3f();
//                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
//                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
//                temp_vector.z = centerPoint.get(2) + z;
//                vertices.add(temp_vector);
//            }
//        }
        ArrayList<Vector3f> temp = new ArrayList<>();
        //Elipsoid
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.1f * (float)(Math.cos(v) * Math.cos(u));
//                float y = 0.1f * (float)(Math.cos(v) * Math.sin(u));
//                float z = 0.1f * (float)(Math.sin(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
        //Hyperboloid satu sisi
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
//                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
//                float z = 0.5f * (float)(Math.tan(v));
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
        //Hyperboloid dua sisi
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
//                float x = 0.5f * (float)(Math.tan(v) * Math.cos(u));
//                float y = 0.5f * (float)(Math.tan(v) * Math.sin(u));
//                float z = 0.5f * (float)(1/Math.cos(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//            for(double u = Math.PI/2; u<= 3*Math.PI/2; u+=Math.PI/60){
//                float x = 0.5f * (float)(Math.tan(v) * Math.cos(u));
//                float y = 0.5f * (float)(Math.tan(v) * Math.sin(u));
//                float z = 0.5f * (float)(1/Math.cos(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
//        Elliptic cone
//        for(double v = -7 ; v<= 7; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.5f * (float)((v) * Math.cos(u));
//                float y = 0.5f * (float)((v) * Math.sin(u));
//                float z = 0.5f * (float)((v));
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
        //Eliptic paraboloid
        for(double v = -7 ; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)((v) * Math.cos(u));
                float y = 0.5f * (float)((v) * Math.sin(u));
                float z = 0.5f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        //Hyperboloid paraboloid
//        for(double v = -7 ; v<= 0; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.1f * (float)((v) * Math.tan(u));
//                float y = 0.1f * (float)((v) * 1/Math.cos(u));
//                float z = 0.1f * (float)(Math.pow(v,2));
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
        vertices = temp;

    }
}
