package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Elliptic_cone extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;

    public Elliptic_cone(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                        int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        //createBox();
        createSphere();
        setupVAOVBO();
    }

    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -5; v<= 5; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)((v) * (Math.cos(u)));
                float y = 0.5f * (float)((v) * (Math.sin(u)));
                float z = 0.5f * (float)(v);
                temp.add(new Vector3f(x,z,y));
            }

        }
        vertices = temp;
    }
}
