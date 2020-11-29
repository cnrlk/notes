# Notes App
An application to create(and edit/delete) and list notes.
# Features
* This application can create a note with given title and description. 
* It will also download the the image and add it on listing page if image url is provided. 
* You can edit or delete notes you have created before.
* On edited notes, <b>edited</b> tag will be visible, and displayed date will be changed to edit date from create date.
# Techs and Frameworks
* Project has developed using <b>java</b> and <b>mvvm</b> architecture pattern.
* For dependency injection, used <b>dagger 2</b>
* For validations on create/edit page, i used my own validation project implemented using Google's <b>databinding library</b>.
* I have also needed to use some other frameworks like: Glide, Parceler, gson etc.
# Unit Tests
Unit tests are implemented for list notes, create notes and delete notes functions.
