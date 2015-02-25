package labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Neil on 2/25/2015.
 */
public class Postfix{
    private static Stack<Double> st = new Stack<Double>();
    public static void main(String[] args)
    {
        ArrayList<String> funcs = new ArrayList<String>(Arrays.asList("*","/","+","-"));

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
    }

    private static void do_operation(String op)
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

}
