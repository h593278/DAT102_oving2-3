package del2;

public class LinearNode <T>{
	 private LinearNode<T> neste;
	 private T element;
	 
	 public LinearNode() {
		 neste = null;
		 element = null;
	 }
	 
	 public LinearNode(T element) {
		 this.element=element;
	 }
	 
	 public T getElement() {
		 return element;
	 }
	 public void setElement(T element) {
		 this.element=element;
	 }
	 public LinearNode<T> getNeste() {
		 return neste;
	 }
	 public void setNeste(LinearNode<T> neste) {
		 this.neste=neste;
	 }
}//class

