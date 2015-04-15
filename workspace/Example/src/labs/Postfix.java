package labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Neil on 2/25/2015.
 */
public class Postfix {
    private Stack<Double> st = new Stack<Double>();
    private static ArrayList<String> funcs = new ArrayList<String>(Arrays.asList("*","/","+","-"));
    /*public static void main(String[] args)
    {

        String ops = "5 3 - 4 8 * + 8 9 2 + - *";

        String[] op_array = ops.split(" ");

        for(String op : op_array)
        {
            boolean is_op = funcs.contains(op);
            if(st.empty() && is_op)
            {
                throw new EmptyStackException();
            }
            if(is_op)
            {
                do_operation(op);
            }
            else
            {
                st.push(Double.parseDouble(op));
            }
            System.out.println(st.toString());


        }
    }*/

    private void do_operation(String op)
    {
        double op1 = st.pop();
        double op2 = st.pop();
        double val = 0;
        switch(op.charAt(0))
        {
            case '+':
                val = op2 + op1;
                break;
            case '-':
                val = op2 - op1;
                break;
            case '*':
                val = op2 * op1;
                break;
            case '/':
                val = op2 / op1;
                break;
            default:
                System.exit( 3 );
        }
        st.push(val);
    }

    public Stack evaluate(String opString)
    {
        String[] op_array = opString.split(" ");
        for(String op : op_array)
        {
            boolean is_op = funcs.contains(op);
            if(st.empty() && is_op)
            {
                throw new EmptyStackException();
            }
            if(is_op)
            {
                do_operation(op);
            }
            else
            {
                st.push(Double.parseDouble(op));
            }
        }
        return st;
    }

}
