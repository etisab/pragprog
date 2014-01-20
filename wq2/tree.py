#
#toy script to explore trees.
#defines a node object with left and right pointers to form a tree, and implements in-order (left to right) traversal (ie, BST ascending order).
#branches of the tree are specified by giving paths from the root node.

class Tree(object):
    def __init__(self):
        self.left = None
        self.right = None
        self.data = "root"
        self.pos = None
        # self.n = 1

    def addPath(self, path = []):

        cur = self

        for choice in path:
            if choice == "L":
                if(cur.left is None):
                    cur.left = Tree()
                cur = cur.left
                cur.data = "left"
                print(cur.pos, cur.data)

            elif choice == "R":
                if(cur.right is None):
                    cur.right = Tree()
                cur = cur.right
                cur.data = "right"
                print(cur.pos, cur.data)

            else:
                print("ignored input ", choice)


    def traverse(self):

        n = [1]				#just a simple counter - must pass as a list for helper function due to python scoping rules
        def t(node):        #inorder traversal - list nodes

            if(node is None):
                return

            t(node.left)
            node.pos = n[0]
            n[0] += 1
            print(node.pos, node.data)
            t(node.right)

        cur = self
        t(cur)


t = Tree()
pathList = [["L", "L", "L"], ["R", "R", "R"], ["L", "R", "L"], ["R", "L", "M"]]
for p in pathList:
    t.addPath(p)

t.traverse()


