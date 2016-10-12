module MyRange where
    myRange start step = start:(myRange (start + step) step)
