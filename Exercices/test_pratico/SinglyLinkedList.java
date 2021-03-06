package test_pratico;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private Node <T> last;
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
/*    public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   } */

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }


   // ------------------------------------------------------------------------------------------------------ \\

   public void add (T value, int position) {

      if (position == 0) {
          addFirst(value);
          return;
      } else if (position == size) {
          addLast(value);
          return;
      } else if (position > size || position < 0) {
          return;
      }

      Node <T> cur = first;
      Node <T> newNode = new Node <>(value, null);

      for(int i = 0; i < position-1; i++) { // loop until the position before the one wanted
          cur = cur.getNext();
      }

      newNode.setNext(cur.getNext());
      cur.setNext(newNode);
      size++;
  }

   // ------------------------------------------------------------------------------------------------------ \\

   public T get(int pos) {
      if (isEmpty())
         return null;

      if (pos < 0 || pos >= size) 
         return null;

      if (pos == 0) 
         return getFirst();
      else if (pos == size-1)
         return getLast();
      else {
         Node<T> cur = first;

         for (int i = 1; i <= pos; i++) {
               cur = cur.getNext();
         }

         return cur.getValue();
      }
   }

   // ------------------------------------------------------------------------------------------------------ \\

   public T remove(int pos) {

      if (isEmpty())
         return null;

      if (pos < 0 || pos >= size) 
         return null;

      if (pos == 0) {
         T first = getFirst();
         removeFirst();
         return first;

      } else if (pos == size-1) {
         T last = getLast();
         removeLast();
         return last;

      } else {
         Node<T> cur = first;

         for (int i = 1; i < pos; i++) 
               cur = cur.getNext();

         T ipos = cur.getNext().getValue();
         cur.setNext(cur.getNext().getNext());
         size--;

         return ipos;
      }

   }
   
   // ------------------------------------------------------------------------------------------------------ \\

   public SinglyLinkedList<T> cut(int a, int k) {
      SinglyLinkedList<T> nlist = new SinglyLinkedList<>();
      Node<T> cur = first;

      for (int i = 0; i < size; i++) {
         if (i >= a && i <= k+a-1)
            nlist.addLast(cur.getValue());
         cur = cur.getNext();
      }


      return nlist;
   }
   
   public void shift(int k) {
      
      if (k == size)
         return;

      for (int i = 0; i < k; i++) {
         addLast(getFirst());
         removeFirst();
      }
   }


   public void addLast (T value) {
      Node<T> newNode = new Node<T>(value, null); 
      if (isEmpty()) {
        first = newNode;
        last = newNode;
      } else {
        last.setNext(newNode);
        last = newNode;
      }
      size++;
   } 



   // ------------------------------------------------------------------------------------------------------ \\

   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }
}
