package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;


public class Hyperboloid extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;

    public Hyperboloid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY,Float radiusZ,int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createSphere();
        setupVAOVBO();
    }
    public void createSphere(){
        vertices.clear();
//        float pi = (float)Math.PI;
//
//        float sectorStep = 2 * (float)Math.PI / sectorCount;
//        float stackStep = (float)Math.PI / stackCount;
//        float sectorAngle, StackAngle, x, y, z;

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

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(1/Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(1/Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }
}
