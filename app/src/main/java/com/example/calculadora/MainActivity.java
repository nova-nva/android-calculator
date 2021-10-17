package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.math.*;

public class MainActivity extends AppCompatActivity {

    EditText operations;
    TextView results;
    ArrayList<String> numbers = new ArrayList<String>(); int in = 0;
    ArrayList<String> operators = new ArrayList<String>(); int io = 0;
    String it="";
    Boolean priority = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operations = findViewById(R.id.etOperaciones);
        results = findViewById(R.id.tvResultado);
    }

    // Button Functions
    public void Delete(View view){
        String cad = String.valueOf(operations.getText());
        if (!cad.isEmpty()){
            Log.i("phx", "MSG: Se está eliminando: " + cad.charAt(cad.length()-1));
            String data = String.valueOf(cad.charAt(cad.length()-1));
            if(data.equals("(")){
                priority = false;
            }
            if(data.equals(")")){
                priority = true;
            }
            if(data.equals("*") || data.equals("/") || data.equals("%") || data.equals("+") || data.equals("-") || data.equals("prior*") || data.equals("prior/") || data.equals("prior%") || data.equals("prior+") || data.equals("prior-") || data.equals("^")) {
                Log.i("phx", "MSG: Esta entrando al caso especial");
                it = numbers.get(in-1);
                numbers.remove(in-1);
                operators.remove(io-1);
                in--;
                io--;
                String ncad = cad.substring(0, cad.length()-1);
                operations.setText(ncad);
            }
            else{
                String ncad = cad.substring(0, cad.length()-1);
                operations.setText(ncad);
                it = it.substring(0, it.length()-1);
                operations.setText(ncad);
            }
        }
    }

    public void One(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(1);
        it+=String.valueOf(1);
        operations.setText(cad);
    }

    public void Two(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(2);
        it+=String.valueOf(2);
        operations.setText(cad);
    }

    public void Three(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(3);
        it+=String.valueOf(3);
        operations.setText(cad);
    }

    public void Four(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(4);
        it+=String.valueOf(4);
        operations.setText(cad);
    }

    public void Five(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(5);
        it+=String.valueOf(5);
        operations.setText(cad);
    }

    public void Six(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(6);
        it+=String.valueOf(6);
        operations.setText(cad);
    }

    public void Seven(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(7);
        it+=String.valueOf(7);
        operations.setText(cad);
    }

    public void Eight(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(8);
        it+=String.valueOf(8);
        operations.setText(cad);
    }

    public void Nine(View view){
        String cad = String.valueOf(operations.getText());
        cad+=String.valueOf(9);
        it+=String.valueOf(9);
        operations.setText(cad);
    }

    public void Zero(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() > 0) {
            if (it.charAt(0) != '0') {
                cad += String.valueOf(0);
                it+=String.valueOf(0);
                operations.setText(cad);
            }
        }
    }

    public void Dot(View view){
        String cad = String.valueOf(operations.getText());
        cad+=".";
        it+=".";
        operations.setText(cad);
    }

    public void Negative(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() == 0) {
            cad += "neg ";
            it+="-";
            operations.setText(cad);
        }
    }

    public void Suma(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            if (priority) {
                operators.add("prior+");
            } else {
                operators.add("+");
            }
            it = "";
            in++;
            io++;

            cad += "+";
            operations.setText(cad);
        }
    }

    public void Resta(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            if (priority) {
                operators.add("prior-");
            } else {
                operators.add("-");
            }
            it = "";
            in++;
            io++;

            cad += "-";
            operations.setText(cad);
        }
    }

    public void Mult(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            if (priority) {
                operators.add("prior*");
            } else {
                operators.add("*");
            }
            it = "";
            in++;
            io++;

            cad += "*";
            operations.setText(cad);
        }
    }

    public void Div(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            if (priority) {
                operators.add("prior/");
            } else {
                operators.add("/");
            }
            it = "";
            in++;
            io++;

            cad += "/";
            operations.setText(cad);
        }
    }

    public void Mod(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            if (priority) {
                operators.add("prior%");
            } else {
                operators.add("%");
            }
            it = "";
            in++;
            io++;

            cad += "%";
            operations.setText(cad);
        }
    }

    public void Pow(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            if (priority) {
                operators.add("prior^");
            } else {
                operators.add("^");
            }
            it = "";
            in++;
            io++;

            cad += "^";
            operations.setText(cad);
        }
    }

    public void Raiz(View view){
        String cad = String.valueOf(operations.getText());
        if (operators.size() > 0) {
            if (it.isEmpty() && !operators.get(operators.size() - 1).equals("sqrt")) {
                operators.add("sqrt");
                it = "";
                io++;

                cad += "sqrt ";
                operations.setText(cad);
            }
        }
        else{
            operators.add("sqrt");
            it = "";
            io++;

            cad += "sqrt ";
            operations.setText(cad);
        }
    }

    public void Raiz3(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("cbrt");
            it = "";
            io++;

            cad += "cbrt ";
            operations.setText(cad);
        }
    }

    public void Log10(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("log10");
            it = "";
            io++;

            cad += "log ";
            operations.setText(cad);
        }
    }

    public void LogN(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("ln");
            it = "";
            io++;

            cad += "ln ";
            operations.setText(cad);
        }
    }

    public void Seno(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("sen");
            it = "";
            io++;

            cad += "sen ";
            operations.setText(cad);
        }
    }

    public void Coseno(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("cos");
            it = "";
            io++;

            cad += "cos ";
            operations.setText(cad);
        }
    }

    public void Tangente(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("tan");
            it = "";
            io++;

            cad += "tan ";
            operations.setText(cad);
        }
    }

    public void Cosecante(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("csc");
            it = "";
            io++;

            cad += "csc ";
            operations.setText(cad);
        }
    }

    public void Secante(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("sec");
            it = "";
            io++;

            cad += "sec ";
            operations.setText(cad);
        }
    }

    public void Cotangente(View view){
        String cad = String.valueOf(operations.getText());
        if(it.isEmpty()) {
            operators.add("ctg");
            it = "";
            io++;

            cad += "ctg ";
            operations.setText(cad);
        }
    }

    public void Factorial(View view){
        String cad = String.valueOf(operations.getText());
        if(it.length() != 0 && !it.equals(".")) {
            operators.add("!");
            io++;

            cad += "!";
            operations.setText(cad);
        }
    }

    public void Parentesis(View view){
        String cad = String.valueOf(operations.getText());
        if(cad.indexOf("(") == -1){
            priority = true;
            cad+="(";
            operations.setText(cad);
        }
        else{
            String subs = cad;
            while(subs.contains("(")){
                Log.i("phx","MSG: escaneando cadena: " + subs);
                if(subs.indexOf(")") == -1){
                    priority = false;
                    cad+=")";
                    operations.setText(cad);
                    return;
                }
                else{
                    int end = subs.indexOf(")");
                    subs = subs.substring(end+1);
                }
            }
            priority = true;
            cad+="(";
            operations.setText(cad);
        }
    }

    public void Clear(View view){
        removeAll();
    }

    private void removeAll(){
        results.setText("");
        operations.setText("");
        it="";
        in=0;
        io=0;
        numbers.clear();
        operators.clear();
        priority = false;
    }

    public void Equals(View view){
        if(it.length() != 0 && !it.equals(".")) {
            numbers.add(it);
            operators.add("=");
            results.setText(String.valueOf(solve()).replaceFirst("\\.0", ""));
            it = "";
            in++;
            io++;

            numbers.clear();
            operators.clear();
        }
    }

    private double solve(){
        Log.i("phx", "NROS: ");
        for(int i = 0; i<numbers.size(); i++){
            Log.i("phx", numbers.get(i));
        }
        Log.i("phx", "OPS: ");
        for(int i = 0; i<operators.size(); i++){
            Log.i("phx", operators.get(i));
        }

        if(operators.size()==1){
            return Double.parseDouble(numbers.get(0));
        }
        else {
            int i=0;
            // operadores de prioridad
            while(operators.contains("prior*") || operators.contains("prior/") || operators.contains("prior%")){
                Log.i("phx", "MSG: Existe prioridad modificada 1, tamaño de vector: " + operators.size());
                if(operators.get(i) == "prior*"){
                    Log.i("phx", "SLV: Detectada multiplicacion, resolviendo...");
                    double op = times(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "prior/"){
                    Log.i("phx", "SLV: Detectada division, resolviendo...");
                    double op = divides(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "prior%"){
                    Log.i("phx", "SLV: Detectado modulo, resolviendo...");
                    double op = mods(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                i++;
            }
            i=0;
            while(operators.contains("prior+") || operators.contains("prior-")){
                Log.i("phx", "MSG: Existe prioridad modificada 2, tamaño de vector: " + operators.size());
                if(operators.get(i) == "prior+"){
                    Log.i("phx", "SLV: Detectada suma, resolviendo...");
                    double op = plus(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "prior-"){
                    Log.i("phx", "SLV: Detectada resta, resolviendo...");
                    double op = less(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                i++;
            }
            i=0;
            while(operators.contains("^") || operators.contains("sqrt") || operators.contains("cbrt") || operators.contains("!") || operators.contains("log10") || operators.contains("ln") || operators.contains("sen") || operators.contains("cos") || operators.contains("tan") || operators.contains("csc") || operators.contains("sec") || operators.contains("ctg")){
                Log.i("phx", "MSG: Existe prioridad 0, tamaño de vector: " + operators.size());
                if(operators.get(i) == "^"){
                    Log.i("phx", "SLV: Detectada exponenciacion, resolviendo...");
                    double op = pow(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "sqrt"){
                    Log.i("phx", "SLV: Detectada raiz cuadrada, resolviendo...");
                    double op = sqrt(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "cbrt"){
                    Log.i("phx", "SLV: Detectado raiz cubica, resolviendo...");
                    double op = cbrt(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "!"){
                    Log.i("phx", "SLV: Detectado factorial, resolviendo... " + numbers.get(i));
                    Log.i("phx", "SLV: Tiene punto? " + numbers.get(i).indexOf("."));
                    if(numbers.get(i).indexOf(".") != -1){
                        Log.i("phx", "entra");
                        Toast.makeText(getApplicationContext(), "Imposible extraer factorial de decimales", Toast.LENGTH_LONG).show();
                        removeAll();
                        return 0;
                    }
                    else {
                        int op = fact(Integer.parseInt(numbers.get(i)));
                        Log.i("phx", "SLV: Resultado: " + op);
                        operators.remove(i);
                        numbers.remove(i);
                        numbers.add(i, String.valueOf(op));
                        i = -1;
                    }
                }
                else if(operators.get(i) == "log10"){
                    Log.i("phx", "SLV: Detectado logaritmo 10, resolviendo...");
                    double op = log(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "ln"){
                    Log.i("phx", "SLV: Detectado logaritmo natural, resolviendo...");
                    double op = ln(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "sen"){
                    Log.i("phx", "SLV: Detectado seno, resolviendo...");
                    double op = sin(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "cos"){
                    Log.i("phx", "SLV: Detectado coseno, resolviendo...");
                    double op = cos(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "tan"){
                    Log.i("phx", "SLV: Detectado tangente, resolviendo...");
                    double op = tan(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "csc"){
                    Log.i("phx", "SLV: Detectado cosecante, resolviendo...");
                    double op = csc(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "sec"){
                    Log.i("phx", "SLV: Detectado secante, resolviendo...");
                    double op = sec(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "ctg"){
                    Log.i("phx", "SLV: Detectado cotangente, resolviendo...");
                    double op = ctg(Double.parseDouble(numbers.get(i)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                i++;
            }
            i=0;
            while(operators.contains("*") || operators.contains("/") || operators.contains("%")){
                Log.i("phx", "MSG: Existe prioridad 1, tamaño de vector: " + operators.size());
                if(operators.get(i) == "*"){
                    Log.i("phx", "SLV: Detectada multiplicacion, resolviendo...");
                    double op = times(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "/"){
                    Log.i("phx", "SLV: Detectada division, resolviendo...");
                    double op = divides(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "%"){
                    Log.i("phx", "SLV: Detectado modulo, resolviendo...");
                    double op = mods(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                i++;
            }
            i=0;
            while(operators.contains("+") || operators.contains("-")){
                Log.i("phx", "MSG: Existe prioridad 2, tamaño de vector: " + operators.size());
                if(operators.get(i) == "+"){
                    Log.i("phx", "SLV: Detectada suma, resolviendo...");
                    double op = plus(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                else if(operators.get(i) == "-"){
                    Log.i("phx", "SLV: Detectada resta, resolviendo...");
                    double op = less(Double.parseDouble(numbers.get(i)), Double.parseDouble(numbers.get(i+1)));
                    operators.remove(i);
                    numbers.remove(i);
                    numbers.remove(i);
                    numbers.add(i, String.valueOf(op));
                    i=-1;
                }
                i++;
            }
            return(Double.parseDouble(numbers.get(0)));
        }
    }

    private double plus(double a, double b){
        return a+b;
    }

    private double less(double a, double b){
        return a-b;
    }

    private double times(double a, double b){
        return a*b;
    }

    private double divides(double a, double b){
        try {
            double res = a / b;
            return res;
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage()+"\nImposible dividir entre 0", Toast.LENGTH_SHORT).show();
            removeAll();
            return 0;
        }
    }

    private double mods(double a, double b){
        return a%b;
    }

    private double sqrt(double a){
        return Math.sqrt(a);
    }

    private double cbrt(double a){
        return Math.cbrt(a);
    }

    private double log(double a){
        return Math.log10(a);
    }

    private double ln(double a){
        return Math.log(a);
    }

    private double pow(double a, double b){
        return Math.pow(a, b);
    }

    private int fact(int a){
        if(a == 0){
            return 1;
        }
        return a * fact(a-1);
    }

    private double sin(double a){
        return Math.sin(a);
    }

    private double cos(double a){
        return Math.cos(a);
    }

    private double tan(double a){
        return Math.tan(a);
    }

    private double sec(double a){
        return Math.acos(a);
    }

    private double csc(double a){
        return Math.asin(a);
    }

    private double ctg(double a){
        return Math.atan(a);
    }
}