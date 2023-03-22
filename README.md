<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<style>
body { font: 14px Verdana, Arial, Helvetica, sans-serif; 
       width: 96%; margin-left: 2%; margin-top: 3%; line-height: 1.5;}
a, a:visited { color: blue; }
table { border-collapse: collapse; cellspacing: 0px; margin-left: 10%;}
th { font: bold 14px Verdana, Arial; border-bottom: 1px solid black; padding: 10px;}
td { padding: 2px; font: 14px Verdana, Arial; }
td.pts { text-align: center; }
tt { color: blue; }
</style>
<title>CS 213 Spring 2023: Assignment 1</title></head>
<body>
<center>
<h3>Assignment 1</h2>
<h3>Song Library Design &amp; Implementation with GUI</h2>
<h3><font color="red">
Posted Tue Feb 7<br>
Due Tue Feb 21 by 11 PM in Canvas<br>
Worth 40 points (4% of course grade.)</h3>
</font>
</center>
<hr>
You will work <b>in pairs</b> on this assignment. Read the
<a href="http://www.cs.rutgers.edu/academics/undergraduate/academic-integrity-policy/programming-assignments">
DCS Academic Integrity Policy for Programmming Assignments</a> - you are responsible
for this. 
<hr>
<p><font color="red">You may use ANY IDE (Eclipse, IntelliJ, NetBeans, VSCode, whatever) for your projects. 

<p>Make sure your project is NOT modular: if you are using Eclipse,
when you create the project
choose <b>Don't create</b> when the create module-info.java dialog pops up.
</font>
<p>Here are some useful sites for Java FX documentation:
<ul>
<li><a href="https://fxdocs.github.io/docs/html5/">Java FX Documentation Project</a>
<li><a href="http://docs.oracle.com/javase/8/javase-clienttechnologies.htm">Oracle documentation on Java FX</a>. See in particular the sections on
<a href="https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/ui_controls.htm#JFXUI336">Work with UI Controls</a> and
<a href="https://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html">Work with Layouts</a>.
<li><a href="https://docs.oracle.com/javase/8/javafx/api/toc.htm">Java FX API</a>
</ul>
<p>Java/Java FX Version: You must use Java 11 or higher. Any version of
Java FX is fine.
<p><b>Read the <a href="#faq">FAQ</a>s!!!</b> at the end of this page.
<hr>
<h3>Requirements</h3>
<p>Design and implement an application with a graphical user interface to manage
a library of songs.<p>
<b>A song is uniquely identified by a combination of 
name and artist (case INsensitive, i.e. upper or lower case are the
same).</b>
<br>This means either name or artist
may be duplicated, but the combination of name and artist may not.<p>
<p>Your application should have a SINGLE WINDOW with three functions:
<ol>
<li><b>Song list display</b>, with the ability to select ONE song from the list. 

<p>The list will
display the name and artist ONLY for each song, in <b>alphabetical order of names</b>
(and <b>within duplicate names, by alphabetical order of artists</b>).
Unless the
list is empty, one song is always pre-selected, and its details shown - see the
following item.
<p><li><b>Song detail</b>, with name, artist, album, and year, of the song that is
selected in the song list interface
<p><li><b>Song Add/Delete/Edit</b>, for adding a new song, deleting a selected song,
and editing a selected song:
<ul>
<p><li><b>Add</b>: When a new song is added, the song name and artist should be entered
at the very least. Year and album are optional. If the name and artist are the
same as an existing song, the add should not be allowed - a message should be
shown in a pop-up dialog, or by some other means within the main application
window.

<p>The newly added song should automatically be placed in the
correct position in the alphabetical order in the list. Also, it should be
automatically selected, replacing the previously selected song, and its details should be shown.
<p><li><b>Edit</b>: ANY of the fields can be changed. But neither of the song
name or artist field can be empty. Again, if name and artist
conflict with those of an existing song, the edit should NOT be allowed - a message
should be shown in a pop-up dialog, or by some other means within the main
application window.
<p><li><b>Delete</b>: Only the selected song in the list can be deleted.
After deletion, the next song
in the list should be selected, and the details displayed. If there is no next
song, the previous song should be selected, and if there is no previous song
either, then the list is empty and the detail info is all blanks.
</ul>
<p>For any of the add/delete/edit actions, your application should ask the user
to confirm or cancel when they trigger the action (click a button) 
to go through with the add/delete/edit. This allows them to back out at the last
minute if they change their mind.
</ol>

<p>Note: If you use the song detail display area for add/delete/edit as well
(instead of two separate areas), then make sure the interface is not
confusing to the user, particularly if the add or edit is disallowed or aborted
by the user.

<p>When your program is started, it should show the current list of songs in the
library, in the song list display, with the first 
song selected by default. (The first time the program
is run, there should be nothing in the display, since there won't be any
songs in the library.)

<p>The song library data should <b>persist</b> across different sessions of your
program. This means any update the user makes to the songs in a run session should
carry over into the next session when the user runs the app again.

<p>To implement persistance, you can save the song list in a file in whatever 
TEXT (human readable)
format you like, and then read it into your program when it starts up. 
This means you may <b>not</b> serialize the data, even if you know how to do it,
because serialized data is not human readable. However, you are free to
use JSON, but make sure you tell your grader which library you used (if any)
to read and write JSON.

<p>Your application is NOT required to play a song when it is selected. In other words,
there is no requirement to have audio playing functionality, and there will not be any
extra credit if you choose to implement this functionality.

<p>The application window need NOT be resizable. 
When the window is closed, the application should be terminated.

<p>Most of the aspects of design (layouts and widgets) 
and implementation (event handling) you need for this assignment
have been covered in class. If there is any aspect you want to add that has not
been covered in class, you are expected to discover these for yourself. You
may use any code posted on the course Canvas site in your projects without 
attribution. 

<p><font color="red">NOTE</font>:
<ul>
<li>You <font color="red">MUST use Java FX</font> for all UI-related code. 
(No Swing stuff.) Any version of Java FX is fine.
<p><li>In your app, there should be <font color="red">only ONE window</font>
for all user interaction.
<p><li>The layout for this single 
application window should be in 
<font color="red">fxml ONLY</font>. In other words, none of the UI 
elements should be created using Java code.
<p><li>You may use pop-ups ONLY to show an error message, or to ask for 
confirm/cancel
of an action, but NOT for anything else - all inputs and edits
    must be done in the single main window.<br>
For the pop-up dialogs, you will NOT be using
fxml since you can work with the standard dialog UIs in the JavaFX framework.
<p>Note: Switching scenes within the main window is fine, since no new windows 
are popped up. Also, partitioning the main window into various sub-areas is
also fine for the same reason.
</ul>
</p><p></p><hr>

<h3>Grading</h3>

<ul>
<table>
<tbody><tr><th>GUI Component</th><th>Points</th></tr>
<tr><td>Song list+selection</td><td class="pts">5</td></tr><tr>
</tr><tr><td>Details display</td><td class="pts">3</td></tr><tr>
</tr><tr><td>Add/Delete/Edit</td><td class="pts">25</td></tr>
</tr><tr><td>Persistence</td><td class="pts">7</td></tr>
</tbody></table>
</ul>

<p>For the first three items, the grade will depend on correctness and
completeness of functionality, as well as <b>effective/appropriate</b> use of 
JavaFX widgets. 
For the last part (persistence), grading is on correctness, and on ensuring this
is transparent to the user, i.e. the user should not have to be concerned with
where and how the song list is stored between sessions.

<p><b>Effective/appropriate</b>
means the UI should be clear, the user should know exactly what to expect when
events are triggered, the user should know exactly what to do to achieve their
objective. <font color="red">If you need to explain to someone
how to use the interface, then it's not a good enough interface. </font>

<p><b>IMPORTANT</b>: Your UI should not use widgets that are an overkill for the 
task at hand because if a complex widget is used for a simple task, it will confuse
the user. So, for instance, do NOT use a table view at all for ANY aspect
of the UI, it will be a major overkill since the requirements do not ask you to 
dynamically rearrange the display on
user request (the kind of thing the table view is used for). If you do so, you will lose credit - see 
the <b>Point Deductions</b> section at the end of this document. Same applies
to tree view.

<p>Finally, your UI is not required to be aesthetically pleasing (no points for 
this because it's highly subjective), but you are most welcome to dazzle us
with your creativity (just for the heck of it!) as long as it does not get in
the way of clean functionality.

<p>You may use any of the classes in the standard Java SDK, but 
<b>no external third-party libraries EXCEPT if you want to use JSON to
store and retrieve song data.</b> If you elect to use JSON,
you will need to use a JSON library (jar)- inform your grader so that
they know to get the library when they test your app.

<p>Alternatively, you may use
the CSV format to store song data, but you do not need an external
library to process CSV - see the <a href="#faq">FAQs</a> (last question) </b>

<hr>

<h3>Submission Instructions </h3>

<p><font color="red">Make sure your project is NOT modular: if you are using Eclipse,
when you create the project
choose <b>Don't create</b> when the create module-info.java dialog pops up.</font>

<p>You may implement the application in as many files as you want,
but you MUST call your main class <tt>SongLib</tt> (this is the class with the
<tt>main</tt> method.) 

<p>Also, you MUST organize your classes into packages. There is no requirement
for how many packages you need to use, as long as there is at least one.
In other words, NONE of your classes must be directly under <tt>src</tt> (which
basically amounts to a default package) - this is bad practice (and is
discouraged by most IDEs) because it
severely limits the way in which you can control access to members of a class.

<p>Make sure to write your names at the top of each of the Java source
files in your project.

<p>Zip your project source and data files into <tt>songlib.zip</tt>. Make sure
to preserve the project directory hierarchy so we can build your project.
Do NOT include binary (.class) files in the zipped collection.

<p>Since you are only submitting Java source and data files, not binaries, it
does not matter what IDE you use (Eclipse, IntelliJ, NetBeans, VSCode) to build
your application. Your grader will be able to build the application in their IDE
out of your source and data files.

<p>Submit your <tt>songlib.zip</tt> file to Canvas. Just ONE submission per team,
please!

<hr>

<h3>Point Deductions</h3>

Be aware that implementing design and functionality as specified,
and submitting ("releasing") your implementation as required, are both important
aspects of software development in the real world. The point deductions
listed here are intended to alert you to this. 

<ul>
<li>5 points, if the application window does not show up at all, but we can
fix the code to make it show. So make sure it actually shows when you run the application. 
<p><li>5 points, if the application window cannot be closed, or it closes but does not
terminate the application
<p><li>5 points, if you do not implement your main method in a class named <tt>SongLib</tt>
(see Submission Instructions)
<p><li>5 points, if you have any code in the default package (directly under <tt>src</tt>)
(see Submission Instructions)
<p><li>Up to 5 points, if you do not write your name at the top of all the files you
submit.
</ul>
<ul>
<p><li>10 points, if the displayed list of songs is not in alphabetical order as 
specified in the <b>Song list display</b> item.
<p><li>10 points, if you did not use FXML for the UI design of the main window. (This
does not apply to the pop-up dialogs to report input errors, or for confirming/canceling
  any of the add/edit/delete actions - for these you will use the standard
  dialog UIs provided by Java FX.)
<p><li>10 points, if any window other than the application frame pops up
at any time (except for error dialogs for incorrect add and edit, if you choose
to use dialogs for these, or dialogs for confirm/cancel of any action).
<p><li>10 points, if you use a Table View or Tree View anywhere.
</ul>
<ul>
<p><li>Points will be deducted for each test case that cannot be tried because either
your data file or your UI does not allow for testing it. The exact number of 
points will depend the point value of the test case(s).
</ul>
<ul>
<li><b>No credit</b>, if you used any external libraries--you are only allowed to use
the standard Java SDK, and optionally JSON (with notification to grader).
<p><li><b>No credit</b>, if your program does not compile, or cannot be run. This is a
course in software development, there is NO excuse to submit something that does
not compile or does not run.
</ul>

<hr>

<a name="faq"></a><h2>FAQs</h2>
<ul>

<p><li><b>Q</b>. Can I use SceneBuilder to make my fxml?
<br><b>A</b>. Yes.

<p><li><b>Q</b>. Can we switch scenes in the main window? Or would that still be
considered a popup/multiple windows?
<br><b>A</b>. You can switch scenes, you are not popping up an independent window 
by doing this.

<p><li><b>Q</b>. What characters are permitted for song name, artist, and album?
<br><b>A</b>. Any printable character except '|' (vertical bar)

<p><li><b>Q</b>. If user enters leading/trailing spaces for name, artist, or album,
should we get rid of them?
<br><b>A</b>. Yes.

<p><li><b>Q</b>. Are we required to show lowercase versions of name and artist when
displaying the song info?
<br><b>A</b>. When you show the info (list or details), it should be exactly as the 
user entered (so they are not surprised). But when you sort in your code, it should 
be case insensitive.

<p><li><b>Q</b>. For the year, do we have to take into account the BC/AD stuff?
<br><b>A</b>. No, the only thing you need to check is that it is a positive integer. 

<p><li><b>Q</b>. Are we allowed to place the text file with the song list directly 
under the project folder? If not, is there a particular place that we should put it in?
<br><b>A</b>. It should be under the project folder, but not under the code folders. 
So either directly under the project folder, or you can make a data folder under 
project, and then put the text file there. (Grading wise, we don't have any 
requirement as such, so what I am saying here is just best practice.)

<p><li><b>Q</b>. For submission, do we need a data file with songs in it?
<br><b>A</b>. No. The first time we run your program, there shouldn't be any
songs in the library, so the display should not show anything.

<p><li><b>Q</b>. Do JSON files count as human readable?
<br><b>A</b>. Yes. "JSON (JavaScript Object Notation) is a lightweight 
data-interchange format. It is easy for humans to read and write." (json.org)
Make sure to tell your grader what library you are using to read and write
JSON.

<p><li><b>Q</b>. If we use CSV file format for storing the data, are we allowed to 
use external libraries.
<br><b>A</b>. To use CSV <a href="https://stackabuse.com/reading-and-writing-csvs-in-java/">you don't need external libraries</a>, but if 
you do want to use externals, make sure to inform your grader so they know what
library to use when they test your application. (WARNING! A song name, artist,
or album could well have a comma in it, so using comma as a separator between
fields is a bad idea.)
</ul>


<hr>


</p>
</body></html>
