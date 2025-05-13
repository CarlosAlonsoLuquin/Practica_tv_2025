public class Arbol {
	
	/* Atributos o elementos*/
    private Nodo raiz;
    private int altura, cantidad, peso;
    
    /* Contructores */
    public Arbol( int valor ) {
        this.raiz = new Nodo( valor );
    }
 
    public Arbol( Nodo raiz ) {
        this.raiz = raiz;
    }
 
    /* Setters y Getters */
    public Nodo getRaiz() {
        return raiz;
    }
 
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    private void addNodo( Nodo nodo, Nodo raiz ) {
        /* 2.- Partiendo de la ra�z preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            /* 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato.*/
            this.setRaiz(nodo);
        }
        else {
            /* 4.- En caso negativo preguntamos: X < Nodo */
            if ( nodo.getValor() < raiz.getValor() ) {
                /* 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar */
                if (raiz.getHojaIzquierda() == null) {
                    raiz.setHojaIzquierda(nodo);
                    raiz.getHojaIzquierda().setPadre(raiz);//asignar el nodo padre al nodo
                }
                else {
                    addNodo( nodo , raiz.getHojaIzquierda());
                }
            }
            else {
                /* 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.*/
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                    raiz.getHojaDerecha().setPadre(raiz);//
                }
                else {
                    addNodo( nodo, raiz.getHojaDerecha());
                }
            }
        }
    }
 
    public void addNodo( Nodo nodo ) {//metodo principal agregar nodo
        this.addNodo( nodo , this.raiz );
       
    }
    /*---------------------RECORRIDO INORDEN----------------------*/
    private void recorridoInorden(Nodo nodo){
    	if(nodo.getHojaIzquierda()!= null){
    		recorridoInorden(nodo.getHojaIzquierda());
    	}
    	System.out.print(nodo.getValor()+" ");
    	
    	if(nodo.getHojaDerecha()!= null){
    		recorridoInorden(nodo.getHojaDerecha());
    	}
    }
    
    public void inorden(){
    	recorridoInorden(this.raiz);
    }
    
    /*---------------------RECORRIDO PREORDEN----------------------*/
    private void recorridoPreorden(Nodo nodo){
    	System.out.print(nodo.getValor()+" ");
    	
    	if(nodo.getHojaIzquierda()!= null){
    		recorridoPreorden(nodo.getHojaIzquierda());
    	}
    	
    	
    	if(nodo.getHojaDerecha()!= null){
    		recorridoPreorden(nodo.getHojaDerecha());
    	}
    }
    
    public void preoden(){
    	recorridoPreorden(this.raiz);
    }
    
    
    
    
    /*---------------------RECORRIDO POSTORDEN----------------------*/
   
    
    /*---------------------NIVEL O ALTURA----------------------*/
    private void altura(Nodo visitado, int nivel) {
        if (visitado != null) {
        	System.out.println("\nnivel:"+nivel + " visitado: "
        						+visitado.getValor());
        	altura(visitado.getHojaIzquierda(), nivel + 1);
        	
            if (nivel > altura) {
                altura = nivel;
            }
            altura(visitado.getHojaDerecha() , nivel + 1);
        }
    }

    public int altura() {
        altura = 0;
        altura(this.raiz, 0);
        return altura;
    }

    /*---------------------PESO----------------------*/
    int contador = 0;
    private void peso(Nodo visitado, int nivel) {
    	
     }

    public int peso() {
        peso = 0;
        peso(this.raiz, 0);
        return contador;
    }

    /*---------------------BUSQUEDA DE UN NODO----------------------*/
    /*Consiste en encontrar determinado dato dentro del �rbol, recorriendo cada uno de los nodos. 
     * La b�squeda de un nodo comienza en el nodo ra�z y sigue estos pasos:
		1.- El dato buscado se compara con el dato del nodo ra�z.
		2.- Si el dato buscado es mayor que el dato ra�z, la b�squeda se reanuda en el sub�rbol derecha.
		Si el dato buscado es menor que el dato ra�z, la b�squeda se reanuda con el sub�rbol izquierdo.
		3.- Si los datos son iguales, la b�squeda se detiene y se muestra un mensaje que diga:
		"El nodo X si existe en el arbol.", en caso contrario decir que "No existe el nodo".*/
   
  
	public static void main(String[] args) {
		Nodo n1 = new Nodo(4);
		Nodo n2 = new Nodo(12);
		Nodo n3 = new Nodo(9);
		
		Arbol arbolito = new Arbol(12);
		arbolito.addNodo(new Nodo(8));
		arbolito.addNodo(new Nodo (7));
		arbolito.addNodo(new Nodo (16));
		arbolito.addNodo(new Nodo (14));
		//arbolito.inorden();
		//arbolito.preoden();
//		arbolito.addNodo(n1);
//		arbolito.addNodo(n2);
//		arbolito.addNodo(n3);
//	
	System.out.println("INORDEN: ");arbolito.inorden();
	System.out.println("\nPreorden: ");arbolito.preoden();
//		
//		arbolito.removeNodo(10);
//		
//		System.out.println("\n INORDEN: ");arbolito.inorden();
//		
//		System.out.println("\nAltura: "+ arbolito.altura());
//		
//		System.out.println("\nPeso: "+ arbolito.peso());
//		
		
	}

}