# UWBHacks2022
Adam Deehring, Chloe Tang, Jaylon Nelson-Sellers, Yash Varde

### Goals of the project: Improving Education using the Cloud

The idea of our project is to improve the student retention of ideas and concepts presented in class, by using repetition and additional resources based on the contents of the lecture.


### Desired user experience
The users of our program are twofold. The first set of users are the Professors, who only need to feed the program the subtitles for their lecture and the give weights to the specific keywords that were mentioned during a given lecture. After this has been done, our program will search for additional resources based on the keywords, with a focus on the words the Professor deemed to be most important in this lecture.

The second users of our program will be the students. These students are intended to  use the output of the program, a text file with the keywords and the additional resources our program found from those keywords, to follow up on specific terms used during the lecture.


### Implementation details
We decided to program our program in Java as we all had the most experience in that language. The *.vtt* file was the chosen starting file format as it is the file format that Zoom outputs from transcripts from a given recording, and because we wanted to improve retention, Zoom became a good target for help with education.

This is accomplished by performing a statistical analysis of the transcript, and reporting back the keywords as determined by our algorithm. Our program takes in a *.vtt* file, and removes the commonly used words as well as filler words, so that the words that are left are less common but more important to the lecture.

We run these specific keywords through an API, SerpApi, to receive additional information on those, so that if a given student requires more resource on a given term, they can easily follow up.

### Issues and Bugs
One of our initial issues was importing the appropriate APIs. This was addressed by running through different APIs and understanding which ones simplified the task the most.

Another major issue was identifying common words that can be skipped. Even though we found a text file containing the 1000 most common English words, testing it out on the Avengers: Endgame transcript resulted in additional undesired common words that were not part of the 1000 in the document. To resolve this issue, we added many of these words from the transcript into the text file and took out the ones that are not very commonly used (like eigenvalue, spectral, quantum, etc.)

### Future Work
Create and develop front-end so that the user can interact with a webpage.

Add a keyword searcher similar to Ctrl + F on Windows but will highlight all specified keywords/keyphrases rather than just one. This can help the user narrow down locations within the transcript that contain both keywords/keyphrases and thus learn how both are related to one another.

Extend our program to be compatible with other file types over and above vtt (e.g. SRT). 
 
 

