package com.test;

import org.tensorflow.ConcreteFunction;
import org.tensorflow.Signature;
import org.tensorflow.Tensor;
import org.tensorflow.op.Ops;
import org.tensorflow.TensorFlow;
import org.tensorflow.op.core.Placeholder;
import org.tensorflow.op.math.Add;
import org.tensorflow.types.TInt32;


/**
 * @author HUGH
 * @Date 2019/11/14 13:00
 * @Description test
 */
public class test {
    public static void main(String[] args) {
            System.out.println("Hello TensorFlow " + TensorFlow.version());

            try (ConcreteFunction dbl = ConcreteFunction.create(test::dbl);
                 Tensor<TInt32> x = TInt32.scalarOf(10);
                 Tensor<TInt32> dblX = dbl.call(x).expect(TInt32.DTYPE)) {
                System.out.println(x.data().getInt() + " doubled is " + dblX.data().getInt());

            }
        }

        private static Signature dbl(Ops tf){
            Placeholder<TInt32> x = tf.placeholder(TInt32.DTYPE);
            Add<TInt32> dblX = tf.math.add(x, x);
            return Signature.builder().input("x", x).output("dbl", dblX).build();
        }
    }


