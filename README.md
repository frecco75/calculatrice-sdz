# Description #

Il s'agit d'une proposition de correction du **MOOC**#1 sur le Java/J2EE, du site [OpenClassrooms.com](http://openclassrooms.com/courses/developpez-des-sites-web-avec-java-ee).

Il s'agit d'une application web écrite en Java/J2EE, sans framework et avec les composants basiques offerts par cet éco-système (servlets, jsp).

### Techniquement ###

Dans la partie I du cours correspondant au MOOC de ce projet, le lecteur n'a pas encore vu les notions avancées de présentation comme les taglibs, la JSTL, velocity ou freemarker.

Nous nous limiterons donc dans le cadre de ce projet aux JSP avec scriplets (qui sont à mon sons à bannir de tout projet..).

### Architecture ###

Cet exemple respecte une architecture monolithique de site grand public avec du code réutilisable structuré (inputs, helpers, servlets..) respectant le principe de responsabilité unique, tout ceci dans un but purement but didactique.

On aurait très bien pu se limiter à 3 fichiers (servlet, jsp, web.xml). 

Cependant l'approche choisie dans cette implémentation est à privilégier dès lors que l'on souhaite un projet maintenable et partagé avec d'autres collaborateurs. 