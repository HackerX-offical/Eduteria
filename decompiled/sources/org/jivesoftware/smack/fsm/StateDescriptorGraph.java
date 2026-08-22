package org.jivesoftware.smack.fsm;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public class StateDescriptorGraph {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(StateDescriptorGraph.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    interface DfsEdgeFound<E> {
        void onEdgeFound(GraphVertex<E> graphVertex, GraphVertex<E> graphVertex2, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GraphVertex<StateDescriptor> addNewStateDescriptorGraphVertex(Class<? extends StateDescriptor> cls, Map<Class<? extends StateDescriptor>, GraphVertex<StateDescriptor>> map) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor<? extends StateDescriptor> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        GraphVertex<StateDescriptor> graphVertex = new GraphVertex<>(declaredConstructor.newInstance(new Object[0]));
        map.put(cls, graphVertex);
        return graphVertex;
    }

    private static final class HandleStateDescriptorGraphVertexContext {
        Map<Class<? extends StateDescriptor>, GraphVertex<StateDescriptor>> graphVertexes;
        private final Set<Class<? extends StateDescriptor>> handledStateDescriptors;
        MultiMap<Class<? extends StateDescriptor>, Class<? extends StateDescriptor>> inferredForwardEdges;

        private HandleStateDescriptorGraphVertexContext(Map<Class<? extends StateDescriptor>, GraphVertex<StateDescriptor>> map, MultiMap<Class<? extends StateDescriptor>, Class<? extends StateDescriptor>> multiMap) {
            this.handledStateDescriptors = new HashSet();
            this.graphVertexes = map;
            this.inferredForwardEdges = multiMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean recurseInto(Class<? extends StateDescriptor> cls) {
            return !this.handledStateDescriptors.add(cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GraphVertex<StateDescriptor> getOrConstruct(Class<? extends StateDescriptor> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            GraphVertex<StateDescriptor> graphVertexAddNewStateDescriptorGraphVertex = this.graphVertexes.get(cls);
            if (graphVertexAddNewStateDescriptorGraphVertex == null) {
                graphVertexAddNewStateDescriptorGraphVertex = StateDescriptorGraph.addNewStateDescriptorGraphVertex(cls, this.graphVertexes);
                Iterator<Class<? extends StateDescriptor>> it = this.inferredForwardEdges.getAll(cls).iterator();
                while (it.hasNext()) {
                    graphVertexAddNewStateDescriptorGraphVertex.getElement().addSuccessor(it.next());
                }
            }
            return graphVertexAddNewStateDescriptorGraphVertex;
        }
    }

    private static void handleStateDescriptorGraphVertex(GraphVertex<StateDescriptor> graphVertex, HandleStateDescriptorGraphVertexContext handleStateDescriptorGraphVertexContext) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = ((StateDescriptor) ((GraphVertex) graphVertex).element).getClass();
        if (handleStateDescriptorGraphVertexContext.recurseInto(cls)) {
            return;
        }
        Set<Class<? extends StateDescriptor>> successors = ((StateDescriptor) ((GraphVertex) graphVertex).element).getSuccessors();
        int size = successors.size();
        HashMap map = new HashMap(size);
        for (Class<? extends StateDescriptor> cls2 : successors) {
            map.put(cls2, handleStateDescriptorGraphVertexContext.getOrConstruct(cls2));
        }
        if (size == 0) {
            throw new IllegalStateException("State " + cls + " has no successor");
        }
        if (size == 1) {
            GraphVertex graphVertex2 = (GraphVertex) map.values().iterator().next();
            graphVertex.addOutgoingEdge(graphVertex2);
            handleStateDescriptorGraphVertex(graphVertex2, handleStateDescriptorGraphVertexContext);
            return;
        }
        HashMap map2 = new HashMap(size);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            StateDescriptor stateDescriptor = (StateDescriptor) ((GraphVertex) it.next()).element;
            Class<?> cls3 = stateDescriptor.getClass();
            for (Class<? extends StateDescriptor> cls4 : stateDescriptor.getSubordinates()) {
                if (!successors.contains(cls4)) {
                    LOGGER.severe(stateDescriptor + " points to a subordinate '" + cls4 + "' which is not part of the successor set");
                } else {
                    lookupAndCreateIfRequired(map2, cls3).addOutgoingEdge(lookupAndCreateIfRequired(map2, cls4));
                }
            }
            for (Class<? extends StateDescriptor> cls5 : stateDescriptor.getSuperiors()) {
                if (!successors.contains(cls5)) {
                    LOGGER.severe(stateDescriptor + " points to a superior '" + cls5 + "' which is not part of the successor set");
                } else {
                    lookupAndCreateIfRequired(map2, cls5).addOutgoingEdge(lookupAndCreateIfRequired(map2, cls3));
                }
            }
        }
        List list = topologicalSort(map2.values());
        for (Class<? extends StateDescriptor> cls6 : successors) {
            Iterator it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((GraphVertex) it2.next()).getElement() == cls6) {
                        break;
                    }
                } else {
                    list.add(new GraphVertex(cls6));
                    break;
                }
            }
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            GraphVertex graphVertex3 = (GraphVertex) map.get(((GraphVertex) it3.next()).element);
            graphVertex.addOutgoingEdge(graphVertex3);
            handleStateDescriptorGraphVertex(graphVertex3, handleStateDescriptorGraphVertexContext);
        }
    }

    public static GraphVertex<StateDescriptor> constructStateDescriptorGraph(Set<Class<? extends StateDescriptor>> set) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        HashMap map = new HashMap();
        GraphVertex<StateDescriptor> graphVertexAddNewStateDescriptorGraphVertex = addNewStateDescriptorGraphVertex(ModularXmppClientToServerConnection.DisconnectedStateDescriptor.class, map);
        MultiMap multiMap = new MultiMap();
        for (Class<? extends StateDescriptor> cls : set) {
            Iterator<Class<? extends StateDescriptor>> it = addNewStateDescriptorGraphVertex(cls, map).getElement().getPredeccessors().iterator();
            while (it.hasNext()) {
                multiMap.put(it.next(), cls);
            }
        }
        Iterator it2 = multiMap.getAll(ModularXmppClientToServerConnection.DisconnectedStateDescriptor.class).iterator();
        while (it2.hasNext()) {
            graphVertexAddNewStateDescriptorGraphVertex.getElement().addSuccessor((Class) it2.next());
        }
        handleStateDescriptorGraphVertex(graphVertexAddNewStateDescriptorGraphVertex, new HandleStateDescriptorGraphVertexContext(map, multiMap));
        return graphVertexAddNewStateDescriptorGraphVertex;
    }

    private static GraphVertex<State> convertToStateGraph(GraphVertex<StateDescriptor> graphVertex, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal, Map<StateDescriptor, GraphVertex<State>> map) {
        StateDescriptor element = graphVertex.getElement();
        GraphVertex<State> graphVertex2 = map.get(element);
        if (graphVertex2 != null) {
            return graphVertex2;
        }
        GraphVertex<State> graphVertex3 = new GraphVertex<>(element.constructState(modularXmppClientToServerConnectionInternal));
        map.put(element, graphVertex3);
        Iterator<GraphVertex<StateDescriptor>> it = graphVertex.getOutgoingEdges().iterator();
        while (it.hasNext()) {
            graphVertex3.addOutgoingEdge(convertToStateGraph(it.next(), modularXmppClientToServerConnectionInternal, map));
        }
        return graphVertex3;
    }

    public static GraphVertex<State> convertToStateGraph(GraphVertex<StateDescriptor> graphVertex, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return convertToStateGraph(graphVertex, modularXmppClientToServerConnectionInternal, new HashMap());
    }

    public static final class GraphVertex<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private VertexColor color;
        private final E element;
        private final List<GraphVertex<E>> outgoingEdges;

        private enum VertexColor {
            white,
            grey,
            black
        }

        private GraphVertex(E e2) {
            this.outgoingEdges = new ArrayList();
            this.color = VertexColor.white;
            this.element = e2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOutgoingEdge(GraphVertex<E> graphVertex) {
            if (this.outgoingEdges.contains(graphVertex)) {
                throw new IllegalArgumentException("This " + this + " already has an outgoing edge to " + graphVertex);
            }
            this.outgoingEdges.add(graphVertex);
        }

        public E getElement() {
            return this.element;
        }

        public List<GraphVertex<E>> getOutgoingEdges() {
            return Collections.unmodifiableList(this.outgoingEdges);
        }

        public String toString() {
            return toString(true);
        }

        public String toString(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("GraphVertex " + this.element + " [color=" + this.color + ", identityHashCode=" + System.identityHashCode(this) + ", outgoingEdgeCount=" + this.outgoingEdges.size());
            if (z) {
                sb.append(", outgoingEdges={");
                Iterator<GraphVertex<E>> it = this.outgoingEdges.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().toString(false));
                    if (it.hasNext()) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
            }
            sb.append(']');
            return sb.toString();
        }
    }

    private static GraphVertex<Class<? extends StateDescriptor>> lookupAndCreateIfRequired(Map<Class<? extends StateDescriptor>, GraphVertex<Class<? extends StateDescriptor>>> map, Class<? extends StateDescriptor> cls) {
        GraphVertex<Class<? extends StateDescriptor>> graphVertex = map.get(cls);
        if (graphVertex != null) {
            return graphVertex;
        }
        GraphVertex<Class<? extends StateDescriptor>> graphVertex2 = new GraphVertex<>(cls);
        map.put(cls, graphVertex2);
        return graphVertex2;
    }

    private static <E> List<GraphVertex<E>> topologicalSort(Collection<GraphVertex<E>> collection) {
        final ArrayList arrayList = new ArrayList();
        dfs(collection, new Consumer() { // from class: org.jivesoftware.smack.fsm.StateDescriptorGraph$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                arrayList.add(0, (StateDescriptorGraph.GraphVertex) obj);
            }
        }, null);
        return arrayList;
    }

    private static <E> void dfsVisit(GraphVertex<E> graphVertex, Consumer<GraphVertex<E>> consumer, DfsEdgeFound<E> dfsEdgeFound) {
        ((GraphVertex) graphVertex).color = GraphVertex.VertexColor.grey;
        int size = graphVertex.getOutgoingEdges().size();
        int i = 0;
        for (GraphVertex<E> graphVertex2 : graphVertex.getOutgoingEdges()) {
            i++;
            if (dfsEdgeFound != null) {
                dfsEdgeFound.onEdgeFound(graphVertex, graphVertex2, i, size);
            }
            if (((GraphVertex) graphVertex2).color == GraphVertex.VertexColor.white) {
                dfsVisit(graphVertex2, consumer, dfsEdgeFound);
            }
        }
        ((GraphVertex) graphVertex).color = GraphVertex.VertexColor.black;
        if (consumer != null) {
            consumer.accept(graphVertex);
        }
    }

    private static <E> void dfs(Collection<GraphVertex<E>> collection, Consumer<GraphVertex<E>> consumer, DfsEdgeFound<E> dfsEdgeFound) {
        for (GraphVertex<E> graphVertex : collection) {
            if (((GraphVertex) graphVertex).color == GraphVertex.VertexColor.white) {
                dfsVisit(graphVertex, consumer, dfsEdgeFound);
            }
        }
    }

    public static <E> void stateDescriptorGraphToDot(Collection<GraphVertex<StateDescriptor>> collection, final PrintWriter printWriter, final boolean z) {
        printWriter.append("digraph {\n");
        dfs(collection, new Consumer() { // from class: org.jivesoftware.smack.fsm.StateDescriptorGraph$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                StateDescriptorGraph.lambda$stateDescriptorGraphToDot$1(printWriter, z, (StateDescriptorGraph.GraphVertex) obj);
            }
        }, new DfsEdgeFound() { // from class: org.jivesoftware.smack.fsm.StateDescriptorGraph$$ExternalSyntheticLambda2
            @Override // org.jivesoftware.smack.fsm.StateDescriptorGraph.DfsEdgeFound
            public final void onEdgeFound(StateDescriptorGraph.GraphVertex graphVertex, StateDescriptorGraph.GraphVertex graphVertex2, int i, int i2) {
                StateDescriptorGraph.lambda$stateDescriptorGraphToDot$2(printWriter, z, graphVertex, graphVertex2, i, i2);
            }
        });
        printWriter.append("}\n");
    }

    static /* synthetic */ void lambda$stateDescriptorGraphToDot$1(PrintWriter printWriter, boolean z, GraphVertex graphVertex) {
        String str;
        boolean zIsMultiVisitState = ((StateDescriptor) graphVertex.element).isMultiVisitState();
        boolean zIsFinalState = ((StateDescriptor) graphVertex.element).isFinalState();
        boolean zIsNotImplemented = ((StateDescriptor) graphVertex.element).isNotImplemented();
        if (zIsMultiVisitState) {
            str = "bold";
        } else if (zIsFinalState) {
            str = "filled";
        } else {
            str = zIsNotImplemented ? "dashed" : null;
        }
        if (str == null) {
            return;
        }
        printWriter.append('\"').append((CharSequence) ((StateDescriptor) graphVertex.element).getFullStateName(z)).append("\" [ ").append("style=").append((CharSequence) str).append(" ]\n");
    }

    static /* synthetic */ void lambda$stateDescriptorGraphToDot$2(PrintWriter printWriter, boolean z, GraphVertex graphVertex, GraphVertex graphVertex2, int i, int i2) {
        printWriter.append("  \"").append((CharSequence) ((StateDescriptor) graphVertex.element).getFullStateName(z)).append("\" -> \"").append((CharSequence) ((StateDescriptor) graphVertex2.element).getFullStateName(z)).append('\"');
        if (i2 > 1) {
            printWriter.append(" [xlabel=\"").append((CharSequence) Integer.toString(i)).append("\"]");
        }
        printWriter.append(";\n");
    }
}
