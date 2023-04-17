package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Curve extends Object {
    List<Vector3f> points = new ArrayList<>();
    List<Integer> numbers;
    List<Vector3f> curve;


    // the vertices should be the circle's line
    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public void CreateCurve(){
        double n = points.size() - 1;
        curve = new ArrayList<>();
        numbers = new ArrayList<>();
        pascalTriangle();

        if (points.size() > 1){
            for (double t = 0; t <= 1; t+=0.01){
                double x = 0;
                double y = 0;
                for (int i = 0; i < points.size(); i++){
                    // based the next calculation on the first one
                    x += (numbers.get(i) * Math.pow((1-t), n - i) * Math.pow(t, i) * points.get(i).x);
                }

                for (int i = 0; i < points.size(); i++){
                    // based the next calculation on the first one
                    y += (numbers.get(i) * Math.pow((1-t), n - i) * Math.pow(t, i) * points.get(i).y);
                }

                curve.add(new Vector3f((float) x, (float) y, 0.0f));
            }
        }

        this.vertices = curve;
    }

    public void pascalTriangle(){
        double n = points.size() - 1;

        for (int r = 0; r <= n; r++) {
            // nCr formula
            double num = factorial(n) / (factorial(n - r)
                    * factorial(r));
            numbers.add((int) num);
        }
    }

    public float factorial(double i)
    {
        if (i == 0)
            return 1;
        return (float) (i * factorial(i - 1));
    }
    public void addVertices(Vector3f newVector){
        points.add(newVector);
        CreateCurve();
        setupVAOVBO();
    }

    public void changeVerticePos(int index, Vector3f newPos){
        points.set(index, newPos);
        CreateCurve();
        setupVAOVBO();
    }
}
