# Info-3-Project
Inventory managment by Leandro Biondi &amp; Sofia Meinardi

Este proyecto intenta simular una gestion de inventarios recurriendo a un arbol AVL como estructura de datos ya que nos permite ordenar alfabeticamente cada nodo que agregamos. Cada nodo del arbol AVL representa un producto el cual tiene un nombre y un stock propio.
Además, se utiliza una lista enlazada para simular un historial de los productos que se van agregando al inventario. Estos quedan ordenados segun fueron agregados al inventario y, aun si se elimina el producto del inventario, este queda registrado en el historial.

Descripcion del codigo.

Clases:

Node: Representa un nodo del arbol AVL que hace referencia a un producto.
  Atributos: 
    rightChild[Node] 
    leftChild[Node]
    height[int] 
    stock[int]
    data[String]
  Funciones:
    Node(String, int) Constructor
    Getters y setters
    
Tree: Representa un arbol AVL en el cual se almacenaran nodos tipo Node.
  Atributos:
    root[Node]
  Funciones:
    Tree(String, int) Constructor
    Boolean isEmpty() Devuelve un valor booleano segun si el arbol tiene al menos un nodo o no.
    Node getRoot() Devuelve el nodo situado en la raiz del arbol.
    int getHeight(Node) Devuelve la cantidad de nodos que se extienden del nodo especificado.
    int getBalance(Node) Devuelve un numero que representa la direncia entre la cantidad de nodos que se extienden del nodo izquierdo y el derecho del nodo especificado. 
    void updateHeight(Node) Actualiza la altura asosiada al nodo(height). Se utiliza cuando se modifica el arbol AVL.
    Node rightRotate(Node) Genera una rotacion a la derecha y devuelve el nodo que queda mas arriba.
    Node rightRotate(Node) Genera una rotacion a la izquierda y devuelve el nodo que queda mas arriba.
    Node rotation(Node) Realiza las rotaciones necesarias segun el balance actual del arbol, permite hasta 2 rotaciones segun el caso. Actualiza las alturas.
    Node insert(String, int, Node) Inserta un nuevo nodo al arbol comparando con los demas nodos ingresados desde la raiz, al finalizar genera las rotaciones necesarias y actualiza las alturas segun sea necesario.
    String getMax(Node) Retorna el valor del nodo que este mas a la derecha del arbol.
    Node delete(String, Node) Elimina un nodo buscandolo segun el nombre del producto. hace las rotaciones y actualizaciones de altura segun sean necesarias. 
    void printInOrder(Node) Imprime el arbol AVL en orden alfabetico.
    Node search(String, Node)  Busca el nodo que contiene el producto con el nombre especificado.
    
listNode: Representa un nodo de una lista    
  Atributos:
    next[listNode]
    stock[int]
    data[String]
  Funciones:
    listNode(String, int) Constructor
    getters y setters

List: Representa un listado de productos y sus stocks
  Atributos:
    head[listNode]
  Funciones:
    List() Constructor
    void Insert(String, int) Inserta el nodo en la lista
    void makeEmpty() Actualiza la lista dejandola vacía
    boolean isEmpty() Devuelve true si la lista se encuentra vacía
    
Main: 
  Atributos:
    consola[Scanner]
    inventario[Tree]
    historial[List]
    opcion[Integer]
  Funciones:
    void buscarProducto(Tree) Solicita el ingreso del nombre de un producto y busca un nodo cuyo nombre coincida. Al encontrarlo, devuelve el nombre y stock
    Tree eliminarProducto(Tree) Solicita el ingreso del nombre del producto que se desea eliminar y, al encontrarlo, borra el nodo que lo contiene
    Tree agregarProducto(Tree, List) Solicita el ingreso del nombre y cantidad de productos y crea un nodo con esta informacion, agregandolo al arbol y a la lista
    void imprimirHistorial(List) Imprime la lista
    void menu() Imprime las operaciones que el sistema ofrece


INSTRUCCIONES PARA EJECUTAR EL PROGRAMA

1) Seleccionamos el ingreso de un producto: Opcion 1. Ingresamos nombre y stock de un producto que será agregado al inventario. Repetir este paso varias veces para tener una amplia variedad de productos.
2) Seleccionamos la eliminacion de un producto: Opcion 2. Ingresamos el producto que deseamos eliminar.
3) Seleccionamos la busqueda de un producto: Opcion 3. Ingresamos el producto que deseamos buscar y en pantalla deberá aparecer, en caso de tenerlo, el nombre y stock que actualmente tiene. Si no, aparecerá mensaje de "Producto no encontrado"
4) Seleccionamos la impresion del inventario: Opcion 4. Se deberá mostrar en pantalla el inventario completo (nombreProducto     stock)
5) Seleccionamos la impresión del historial: Opcion 5. Se deberá mostrar en pantalla un listado de los productos que hay actualmente y que hubo alguna vez.
6) Seleccionamos exit: Opcion 0;    
