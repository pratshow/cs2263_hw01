# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).
This project used [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.2.0] - 2021 - 09 - 14
### Added
 - Added the ability to output any inputed equations into a file using `-o [file]` or `--output [file]`
 - When using the `-o` command it creates a file if it doesn't exist
### Removed
 - Removed the dummy math.txt file so the user can make one themselves and test it.

## [1.1.0] - 2021 - 09 - 13
### Added
 - Added the ability to evaluate expressions from the command line or from a file using `-b [file]`
 - The command line can enter "live mode" when you use 'gradle run' and simulate a terminal where you can use all the commands. (P.S if launching in live mode I suggest using `gradle --console plain run` so it looks a lot nicer.)
 - Added a dummy math.txt file with some expressions to evalue when using `-b` or `--batch`

## [1.0.0] - 2021 - 09 - 10
### Added
 - Added basic CLI functionality.
 - Capable of displaying help input and reconizing when an unknown argument is entered.
 - Command for `-h`, `-o`, `-b` are implemented but -o and -b simply echo the file name.

### Changed
 - Updated README to properly show Installation and Usage

### Removed

