# web-spider
web crawling and count word frenquency, cut leaf only keep nouns and verbs to analysis common topic from bunches of webpages

## Java -jar file is in folder"/out/artifacts/...", no need to configure
## execution instruction demo is in folder"/demo/..."

documentation will be uplad afterward.
My java hard code solution is:
1.  read html file through the url we input,
2.  then use regular expression to remeove html, style, script tag, 
3.  next to count the frequency of every word and sort in descending order then output them.
4.  My next step is to romove Conjunctions, prepositions, pronouns....the left nouns and verbs are a smaller range of topics.
To realize this, we can use "nlp tagger" from stanford.
5.  when we get the frequency of nouns and verbs as our content list of this webpage, we can compare several webpage's content list and find their common contentlist.

To find the common content list, we can also use HashMap<word, setdefaultfrequency as1> to loop the first contentlist, adn set the default value of every word as 1.
Then we loop the 2nd contentlist and update the HashMap, then loop the third contentlist and update HashMap.
After a third loop, we remove nodes those value == 1 to reduce space usage, which determines only appear once.
We can loop any times until all Urls have been analysised.

Note:
My Crawling method doesn't works for Amazon webpage currently, the results of content of amazon wepage needs encode conversion to UTF-8.
in the folder"content/", I save the results of crawling output step by step.
currently I am seeking for some solution to convert amazon webpage content into UTF-8 encode.
