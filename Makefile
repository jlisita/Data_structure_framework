JFLAGS = -g
JC = javac
SRCDIR=src
BINDIR=bin
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java -classpath $(SRCDIR) -d $(BINDIR)

CLASSES = \
		$(SRCDIR)/ElementList.java \
		$(SRCDIR)/Structure.java \
		$(SRCDIR)/ArrayStruct.java \
		$(SRCDIR)/Failure.java \
		$(SRCDIR)/Set.java \
		$(SRCDIR)/LinkedSet.java \
		$(SRCDIR)/MultiSet.java \
		$(SRCDIR)/MultiLinkedSet.java \
		$(SRCDIR)/List.java \
		$(SRCDIR)/MultiList.java \
		$(SRCDIR)/LinkedStruct.java \
		$(SRCDIR)/Window.java \
		$(SRCDIR)/Menu.java \
		$(SRCDIR)/ClassTest.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) $(BINDIR)/*.class