package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tail extends Object{
    private List<float[]> PCont = new ArrayList<>();
    public Tail(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<float[]> PCont) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint= Arrays.asList(PCont.get(0)[0], PCont.get(0)[1], PCont.get(0)[2]);
        this.PCont = PCont;
        curve();
        setupVAOVBO();
    }

    @Override
    public void draw(Camera camera, Projection projection) {
        super.draw(camera, projection);
    }

    private int factorial (int a){
        int f =1;
        for (int i = 1; i <= a; i++){
            f*=i;
        }
        return f;
    }

    private int cmb(int n, int r){
        return factorial(n)/(factorial(r) * factorial(n-r));
    }

    private int[] psc(List<float[]> temp){
        int[] ret = new int[temp.size()];
        for (int i =0; i < temp.size(); i++){
            ret[i] = cmb(temp.size()-1, i);
        }
        return ret;
    }

    private ArrayList<float[]> bezier(){
        ArrayList<float[]> g = new ArrayList<>();
        int[] pascal = psc(this.PCont);
        for (float u = 0f; u <= 1; u += 0.01f){
            float x = 0;
            int temp = this.PCont.size()-1;
            for (int a = 0; a < this.PCont.size(); a++){
                x += pascal[a]*Math.pow((1-u), temp)*Math.pow(u, a)*this.PCont.get(a)[0];
                temp--;
            }
            float y = 0;
            temp = this.PCont.size()-1;
            for (int a = 0; a < this.PCont.size(); a++){
                y += pascal[a]*Math.pow((1-u), temp)*Math.pow(u, a)*this.PCont.get(a)[1];
                temp--;
            }
            float z = 0;
            temp = this.PCont.size()-1;
            for (int a = 0; a < this.PCont.size(); a++){
                z += pascal[a]*Math.pow((1-u), temp)*Math.pow(u, a)*this.PCont.get(a)[1];
                temp--;
            }
            float[] cor = {x, y, z};
            g.add(cor);
        }

        return g;
    }

    public void curve(){
        if (this.PCont.size() <= 0) return;

        ArrayList<float[]> b = bezier();

        for (float[] i:
                b) {
            vertices.add(new Vector3f(i[0],i[1],0));
 }
}
}