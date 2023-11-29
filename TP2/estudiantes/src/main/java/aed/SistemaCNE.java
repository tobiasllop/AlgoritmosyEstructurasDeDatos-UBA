package aed;
public class SistemaCNE {
    private String[] nombresPartidos;
    private String[] nombresDistritos;
    private int[] bancasPorDistrito; // El indice es el IdDistrito
    private int[] maximosRangosDeMesas;
    private int[] votosPresidente; // El indice es el IdPartido
    private int[][] mesas_escrutadas; // IdDistrito x IdPartido
    // es para ballotaje
    private boolean ballotage;
    private int[] masVotado;
    private int[] segundoMasVotado;
    private int votosTotales;
    // para bancas
    private Heap[] heaps_cocientes; // longitud D(distritos)
    private int[][] cant_bancas; // D X P
    //private int[] votos_totales_diputados; // longitud D (distritos)
    private boolean[] bancas_calculadas; //D
    public class VotosPartido{
        private int presidente; 
        private int diputados;
        VotosPartido(int presidente, int diputados){
            this.presidente = presidente;
            this.diputados = diputados;
        }
        public int votosPresidente(){
            return presidente;
        }
        public int votosDiputados(){
            return diputados;
        }
    }
    // INVREP:
    /*
        InvRep(s: SistemaCNE){
        |s.nombresPartidos|=|s.votosPresidente| &&
        |s.nombresDistritos|=|s.bancasPorDistrito|=|s.maximosRangosDeMesas|=|s.bancas_calculadas| &&
        |s.mesas_escrutadas|=|s.cant_bancas|=|s.nombresDistritos| && 
        (forall i: int :: 0<=i<|s.nombresDistritos| ==> 
        |s.mesas_escrutadas[i]|=|s.cant_bancas[i]|=|s.nombresPartidos|) && 
        ( forall i,j: int : 0<=i<|s.nombresDistritos| && 0<=j<|s.nombresPartidos| ==> 
        s.mesas_escrutadas[i][j]>=0 && s.cant_bancas[i][j]) && 
        |s.masvotado|==|s.segundoMasVotado|=2 &&
        ( forall c:int :: c in s.bancasPorDistrito || c in s.maximosRangosDeMesas || 
        c in s.votosPresidente || c in s.masVotado || c in s.segundoMasVotado 
        || c in s.heap_cocientes || c in s.votos_totales_diputados  || c in s.bancas_calculadas ==> c>=0) 
        && s.votosTotales >=0 
        
        }
    */
    public SistemaCNE(String[] _nombresDistritos, int[] diputadosPorDistrito,
            String[] _nombresPartidos, int[] ultimasMesasDistritos) {
        
        //Complejidad = O(P + D + P*D) = O(P*D)
        nombresDistritos = _nombresDistritos;
        nombresPartidos = _nombresPartidos;
        bancasPorDistrito = diputadosPorDistrito;
        maximosRangosDeMesas = ultimasMesasDistritos;
        votosPresidente = new int[_nombresPartidos.length]; // O(P)
       
        mesas_escrutadas = new int[_nombresDistritos.length][_nombresPartidos.length]; // O(P*D)
        heaps_cocientes = new Heap[_nombresDistritos.length]; // O(D)
        cant_bancas = new int[_nombresDistritos.length][_nombresPartidos.length]; // O(P*D)
        //votos_totales_diputados = new int[_nombresDistritos.length]; // O(D)
        bancas_calculadas = new boolean[_nombresDistritos.length];  // O(D)
        ballotage = true; //O(1)
        votosTotales = 0; //O(1)
        masVotado = new int[2]; //O(1)
        segundoMasVotado = new int[2]; //O(1)
    }
    public String nombrePartido(int idPartido) {
        // Complejidad: O(1)
        return nombresPartidos[idPartido]; 
    }
    public String nombreDistrito(int idDistrito) {
        // Complejidad: O(1)
        return nombresDistritos[idDistrito];
    }
    public int diputadosEnDisputa(int idDistrito) {
        // Complejidad: O(1)
        return bancasPorDistrito[idDistrito];
    }
    public String distritoDeMesa(int idMesa) {
        //Complejidad: O(log D)
        int idDistrito = idDistritoDeMesa(idMesa); //O(log D)
        return nombreDistrito(idDistrito); //O(1)
    }
    private int idDistritoDeMesa(int idMesa) {
        // Complejidad O(log D)
        int rangoMesa = -1;         //O(1)
        int izquierda = 0;          //O(1)
        int derecha = maximosRangosDeMesas.length - 1;  //O(1)
        boolean loEncontre = false;                     //O(1)
        while (izquierda <= derecha && loEncontre == false){  // O(Log D)
            int medio = izquierda + (derecha - izquierda) / 2;  //O(1)
            // Casos que tengo que decidir entre dos cual es
            if(izquierda == medio){                         //O(1)
                if(idMesa < maximosRangosDeMesas[izquierda]){  //O(1)
                    rangoMesa = izquierda;                     //O(1)
                    loEncontre = true;                         //O(1)
                }
                else{
                    rangoMesa = derecha;                       //O(1)
                    loEncontre = true;                         //O(1)
                }
            }
            // Caso que sea exactamente el del medio
            else if((maximosRangosDeMesas[medio] > idMesa && maximosRangosDeMesas[medio - 1] < idMesa) || maximosRangosDeMesas[medio - 1] == idMesa){ // Caso que es medio + caso que es igual a medio - 1
                rangoMesa = medio;      //O(1)
                loEncontre = true;      //O(1)
            }
            // Caso que esta a la derecha 
            else if(maximosRangosDeMesas[medio] <= idMesa){     //O(1)
                izquierda = medio + 1;                          //O(1)
            } 
            // Caso que esta a la izquierda
            else if(maximosRangosDeMesas[medio] > idMesa){      //O(1)
                derecha = medio - 1;                            //O(1)
            }
        }
        return rangoMesa;
    }
    public void registrarMesa(int idMesa, VotosPartido[] actaMesa) {
        
        //complejidad : O(log(D) + 3*P + 1) = O(log(D) + P)
        int idDistrito = idDistritoDeMesa(idMesa); // O(log D)
        int votos_totales_diputados = 0;  // O(1)
        for (int i = 0; i < actaMesa.length; i++) { // O(P)
            votosPresidente[i] += actaMesa[i].votosPresidente();  // O(1)
            votosTotales += actaMesa[i].votosPresidente();     //O(1)
            //votos_totales_diputados[idDistrito] += actaMesa[i].votosDiputados();  //O(1)
            votos_totales_diputados += actaMesa[i].votosDiputados();  //O(1)
            mesas_escrutadas[idDistrito][i] += actaMesa[i].diputados;  //O(1)
            // defino los 2 más votado para hayBallotage
            if (votosPresidente[i]>masVotado[0]){  // acceder a posicion de votosPresidente O(1) y posicion de array masVotado O(1) 
                if( i != segundoMasVotado[1]){     // O(1)
                    segundoMasVotado[0] = masVotado[0]; // cambiar valor de array es O( longitud(segundoMasVotado) = 2)  ==> O(2) ==> O(1)
                    segundoMasVotado[1] = masVotado[1]; // O(1)
            }
                masVotado[0] = votosPresidente[i];  //O(1)
                masVotado[1] = i;                   //O(1)
            }
            else{
                if (votosPresidente[i]>segundoMasVotado[0] && i != masVotado[1]){   //O(1)
                    segundoMasVotado[0] = votosPresidente[i];                       //O(1)
                    segundoMasVotado[1] = i;                                        //O(1)
                }
            }
        }
        double umbral = (3 * votos_totales_diputados) / 100; //O(long(votos_totales_diputados[idDistrito] = 1)) = O(1)
        int[] listaDHondt = mesas_escrutadas[idDistrito].clone(); //O(P)
        //Seteamos los votos a 0 de los partidos que no pasan el umbral del 3%
        for (int idPartido=0; idPartido < listaDHondt.length; idPartido++){  //O(P)
            if (listaDHondt[idPartido] <= umbral){
                listaDHondt[idPartido] = 0;  // O(1)
            }
        }
        // Seteamos en 0 los votos en blanco
        listaDHondt[nombresPartidos.length-1] = 0; // O(1)
        heaps_cocientes[idDistrito] = new Heap(listaDHondt); //O(P)
        
    }
    public int votosPresidenciales(int idPartido) {
        //Complejidad O(1)
        return votosPresidente[idPartido];
    }
    public int votosDiputados(int idPartido, int idDistrito) {
        //Complejidad O(1)
        return mesas_escrutadas[idDistrito][idPartido];
    }
    public int[] resultadosDiputados(int idDistrito) {
        //Complejidad: si el distrito no lo habíamos calculado O(Dd + log(P)) y si ya estaba calculado O(1)
        int diputadosDeDistrito = diputadosEnDisputa(idDistrito); //O(1)
        
        if (bancas_calculadas[idDistrito] == false) {  // O(1) nos fijamos si el distrito ya lo calculamos anteriormente
            // Asignar bancas a los partidos
            for (int i = 0; i < diputadosDeDistrito; i++) { //O(Dd)
                int partidoGanador = heaps_cocientes[idDistrito].obtenerMaximo_IdPartido(); // Obtener el idPartido O(1)
                cant_bancas[idDistrito][partidoGanador]++; //O(1)
                heaps_cocientes[idDistrito].eliminarRaiz(); //O(1)
                int nuevo_nodo = mesas_escrutadas[idDistrito][partidoGanador]
                        / (cant_bancas[idDistrito][partidoGanador] + 1); //O(1)
                heaps_cocientes[idDistrito].insertar(nuevo_nodo, partidoGanador); //O(log P)
            }
        }
        bancas_calculadas[idDistrito] = true; //O(1)  decimos que ese distrito ahora está calculado
        return cant_bancas[idDistrito];
    }
    
    public boolean hayBallotage() {
        //complejidad: O(1)
        if (masVotado[0]*100/votosTotales >= 45){ //acceder a posición de array o(1) y acceder a votos totales int o(1)
            ballotage = false;                    // ballotage es bool, o(1)
        }
        
        if (masVotado[0]*100/votosTotales >= 40 && (masVotado[0]-segundoMasVotado[0])*100/votosTotales >= 10){  //o(1)
            
            ballotage = false;   //o(1)
        }
        return ballotage;
    }
}

