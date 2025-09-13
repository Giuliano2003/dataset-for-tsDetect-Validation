package de.idos.operatingreserve.internal.client.interaction;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExtensibleDeepProxy_Test {

    @Test
    public void returnsAProxyForEachCall() throws Exception {
        A proxy = ExtensibleDeepProxy.Create(A.class);
        B deepProxy = proxy.giveMeB();
        assertThat(deepProxy, is(not(nullValue())));
    }

    @Test
    public void callsRegisteredMethods() throws Exception {
        ExtensibleDeepProxy extensibleDeepProxy = new ExtensibleDeepProxy();
        MethodHandler methodHandler = mock(MethodHandler.class);
        when(methodHandler.getName()).thenReturn("toString");
        when(methodHandler.invoke(anyObject())).thenReturn("Hallo");
        extensibleDeepProxy.register(methodHandler);
        A proxy = extensibleDeepProxy.create(A.class);
        assertThat(proxy.toString(), is("Hallo"));
    }

}