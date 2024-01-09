package s14_Lambda_functional_interface_n_method_reference.LambdaExpressions;

@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
