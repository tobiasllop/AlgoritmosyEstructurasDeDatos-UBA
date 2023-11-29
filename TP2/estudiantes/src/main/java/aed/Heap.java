package aed;

public class Heap implements InterfazHeap {
    private Nodo[] _heap;

    public class Nodo {
        int valor;
        int idPartido;

        public Nodo(int valor, int idPartido) {
            this.valor = valor;
            this.idPartido = idPartido;
        }
    }

    public int obtenerMaximo() {
        return _heap[0].valor;
    }

    public int obtenerMaximo_IdPartido() {
        return _heap[0].idPartido;
    }

    public Heap(int longitud) {
        _heap = new Nodo[longitud];
    }

    public Heap(int[] lista) {
        _heap = new Nodo[lista.length];
        for (int i = 0; i < lista.length; i++) {
            _heap[i] = new Nodo(lista[i], i);
        }
        BuildMaxHeap();
    }

    public void eliminarRaiz() {
        Nodo temp = _heap[_heap.length - 1];
        _heap[0] = new Nodo(temp.valor, temp.idPartido);
        _heap[_heap.length - 1] = new Nodo(-1, -1);
        maxHeapify(0);
    }

    public void insertar(int elem, int idPartido) {
        _heap[_heap.length - 1] = new Nodo(elem, idPartido);
        int i = _heap.length - 1;
        while (i != 0 && _heap[i].valor > _heap[padre(i)].valor) {
            Nodo temp = _heap[padre(i)];
            _heap[padre(i)] = _heap[i];
            _heap[i] = temp;
            i = padre(i);
        }
    }   

    public String toString(){
        String res="";
        for (Nodo i : _heap) {
            res+=i.valor;
        }
        return res;
    }

    public int encontrarPosicion(int elem){
        int res=-1;
        for (int i = 0; i < _heap.length; i++) {
            if(_heap[i].valor==elem){
                res=i;
                break;
            }
        }
        return res;
    }
    
    public int getMaximosVotos(){
        return _heap[0].valor;
    }

    private void BuildMaxHeap(){
        for(int i=((_heap.length)/2)-1;i>=0;i--){
                maxHeapify(i);
            }
    }

    private void maxHeapify(int i){
        int largest=i;
        int l = izquierdo(i);
        int r = derecho(i);

        if(l<_heap.length && _heap[l].valor>_heap[i].valor){
            largest = l;
        } 

        if(r<_heap.length && _heap[r].valor>_heap[largest].valor){
            largest = r;
        } 

        if(largest !=i){
            Nodo temp  = _heap[i];
            _heap[i] = _heap[largest];
            _heap[largest] = temp; 
            maxHeapify(largest);
        }
    }

    private int izquierdo(int posicionNodo){
        return 2*posicionNodo+1;
    }

    private int derecho(int posicionNodo){  
        return 2*posicionNodo+2;
    }

    private int padre(int posicionNodo){
        return (posicionNodo-1)/(2);
    }
}
        