package br.cesed.si.p3.ed.warray;

/**
 * Class that represents my own array.
 * 
 * Internally it's has internal limitations but
 * 
 * when the limits has been exausthed the intenal limit is dobled.
 * 
 * @author abella
 *
 */
public class Warray {

	
	/*
	 * Crie exce��es para InvalidIndexException
	 * Aplicar InvalidValueException nos outros m�todos
	 */
	private int pos;
	private Object[] elementos;
	private static final int DOBRO = 2;
	private static final int SIZEUPS = 18;
	
	/**
	 * Constructor for my own array.
	 * 
	 * @param tamanho the initial size for my array
	 */
	public Warray(int tamanho) {
		elementos = new Object[tamanho];
	}
	
	/**
	 * Add an element for my array 
	 * 
	 * @param o element to be added 
	 * @throws InvalidValueException 
	 */
	public void adiciona(Object o) throws InvalidValueException {
		//TODO implementa��o do m�todo
		if(o == null) {
			throw new InvalidValueException();
		}else{
			if(pos == this.elementos.length ){
				aumentaCapacidade();
			}
			elementos[pos++] = o;
		}		
	}
	
	private void aumentaCapacidade(){
		Object[] copiaElementos = new Object[(this.pos * DOBRO) + SIZEUPS];
		for(int i = 0; i <= elementos.length;i++){
			copiaElementos[i] = elementos[i];
		}
		elementos = copiaElementos;
	}
	
	/**
	 * Remove an element for my array 
	 * 
	 * @param o element to be removed 
	 * @throws InvalidIndexException 
	 * @throws InvalidValueException 
	 * @throws ValueNotFoundException 
	 */
	public void remove(Object o) throws InvalidValueException, InvalidIndexException, ValueNotFoundException {
		int posicao = 0;
		
		if(o == null){
			throw new InvalidValueException();
		}else{
			for (Object object : elementos) {
				if(object!= null && object.equals(o)){
					removePosicao(posicao);
				} else if (posicao == pos){
					throw new ValueNotFoundException();
				}
			}
		}
		
	}
	
	/**
	 * Remove an element for my array by index
	 * 
	 * @param index the index of element that will be removed
	 * @throws InvalidIndexException 
	 * @throws InvalidValueException 
	 */
	public void removePosicao(int index) throws InvalidIndexException, InvalidValueException {
		if(!(index >= 0 && index < size())){
			throw new InvalidIndexException();
		}
		
		if(elementos[index] != null){
			elementos[index] = null;
		} else {
			throw new InvalidValueException();
		}
		
	}
	
	/**
	 * Size of array
	 * 
	 * @return size of array
	 */
	public int size() {
		int cont = 0;
		for (Object object : elementos) {
			if(!(object==null)){
				cont++;
			}
		}
		return cont;
	}
	
	/**
	 * Convert my own array to native array
	 * 
	 * @return the converted native array
	 */
	public Object[] toArray() {
		return null;
	}
	
	/**
	 * Prints all the elements
	 */
	public void listar() {
		//TODO imprimir todos os elementos da lista
	}
	
	/**
	 * Get the element by index 
	 * @param index index of element 
	 * @return searched element
	 */
	public Object get(int index) {
		return null;
	}
	
}
