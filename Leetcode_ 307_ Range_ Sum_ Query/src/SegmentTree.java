public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
            this.merger = merger;
            data = (E[])new Object[arr.length];
            for (int i = 0 ; i < arr.length ;i++)
                data[i] = arr[i];

            tree = (E[])new Object[4 * arr.length];
            buildSegmentTree(0,0,arr.length-1);
        }

   //在treeIndex的位置創建表示區間[l....r]的線段樹
    private void buildSegmentTree(int treeIndex,int l,int r){
            if (l == r){
                    tree[treeIndex] = data[l];
                    return;
                }
            int  leftTreeIndex = leftChild(treeIndex);
            int  rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l)/2;
            buildSegmentTree(leftTreeIndex,l,mid);
            buildSegmentTree(rightTreeIndex,mid+1,r);

            tree[treeIndex] =merger.merge(tree[leftTreeIndex] ,tree[rightTreeIndex]);
        }

    public int getSize(){
            return data.length;
        }

    public E get(int index){
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal.");
            return data[index];
        }

    //返回完全二叉樹的樹組表示, 一個索引所表示的元素的左孩子節點索引
    private int leftChild(int index){
            return 2*index+1;
        }

    //返回完全二叉樹的樹組表示, 一個索引所表示的元素的右孩子節點索引
    private int rightChild(int index){
            return 2*index+2;
        }

    //返回區間[queryL, queryR]的值
    public E query(int  queryL,int  queryR){
            if ( queryL < 0 ||  queryL >= data.length || queryR < 0 ||  queryR >= data.length || queryL > queryR)
                throw new IllegalArgumentException("Index is illegal.");
            return query(0,0,data.length-1,queryL,queryR);
        }

    //在以 treeID 為根的線段樹中[l...r]範圍裡,搜索區間[queryL,queryR]的值
    private E  query(int treeIndex,int l,int r,int  queryL,int  queryR){
            if (l == queryL && r == queryR)
                return tree[treeIndex];
            int mid = l + (r - l)/2;
            int  leftTreeIndex = leftChild(treeIndex);
            int  rightTreeIndex = rightChild(treeIndex);

            if (queryL >= mid+1)
                return query(rightTreeIndex,mid+1,r,queryL,queryR);
            else if (queryR <= mid)
                return query(leftTreeIndex,l,mid,queryL,queryR);

            E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
            E rigthtResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
            return merger.merge(leftResult,rigthtResult);
        }

    //將 index 位置的值,更新為 e
    public void set(int index,E e){
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal.");
            data[index] = e;
            set(0,0,data.length-1,index,e);
        }

    //在以treeIndex為根的線段樹中更新index的值為e
    private void set(int treeIndex,int l,int r,int index,E e){
            if (l == r){
                    tree[treeIndex] = e;
                    return;
                }
            int mid = l + (r - l)/2;
            int  leftTreeIndex = leftChild(treeIndex);
            int  rightTreeIndex = rightChild(treeIndex);
            if (index >= mid+1)
                set(rightTreeIndex,mid+1,r,index,e);
            else //index <= mid
                set(leftTreeIndex,l,mid,index,e);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
        }


    public String toString(){
           StringBuffer res = new StringBuffer();
           res.append('[');
           for (int i = 0;i < tree.length;i++){
                    if (tree[i] != null)
                        res.append(tree[i]);
                    else
                        res.append("null");

                    if (i != tree.length - 1)
                        res.append(", " );
                }
            res.append(']');
            return res.toString();
        }

}
