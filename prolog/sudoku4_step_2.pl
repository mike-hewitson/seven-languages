%% ---
%%  Excerpted from "Seven Languages in Seven Weeks",
%%  published by The Pragmatic Bookshelf.
%%  Copyrights apply to this code. It may not be used to create training material, 
%%  courses, books, articles, and the like. Contact us if you are in doubt.
%%  We make no guarantees that this code is fit for any purpose. 
%%  Visit http://www.pragmaticprogrammer.com/titles/btlang for more book information.
%%---
sudoku(Puzzle, Solution) :-
        Solution = Puzzle, 
        Puzzle = [_S11, _S12, _S13, _S14, 
                  _S21, _S22, _S23, _S24, 
                  _S31, _S32, _S33, _S34, 
                  _S41, _S42, _S43, _S44], 
        fd_domain(Puzzle, 1, 4).
        
