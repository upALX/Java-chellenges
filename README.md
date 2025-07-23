# Java chell

*Overview*

A public repo with Java solved challenges.

---

**required**:

- java >= 21.0.7
- maven >= 3.8.7

**How to use**:

1 - Clone this repo:

```git clone git@github.com:upALX/Java-chellenges.git jc```

2 - BASH: Compile de code using maven (on the same level at poml.xml file of challenge selected):

```mvn compile```

3 - BASH: Run the selected challenge (on the same level at poml.xml file of challenge selected):

```mvn exec:java```

or 

```mvn exec:java -Dexec.mainClass="com.challenges.challenge-name.Main"```

## Next steps

1 - makefile that configures all the challenges in an easy-to-configure environment ready for use;
2 - An iterative bash for choosing challenges;
