# sample makefile
# Liyabona Sodoza
# 29 February 2024

.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES1=GenericsKb.class \
	 GenericsKbArray.class \
	 GenericsKbArrayApp.class \
         BinaryTreeNode.class BTQueueNode.class \
         BTQueue.class BinaryTree.class \
         BinarySearchTree.class

CLASSES=$(CLASSES1:%.class=$(BINDIR)/%.class)

default: $(CLASSES)

run: $(CLASSES)
	$(JAVA) -cp $(BINDIR) GenericsKbArrayApp
	
	
clean:
	rm $(BINDIR)/*.class