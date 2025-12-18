#ifndef __ALGORITHM__
#define __ALGORITHM__

#include "Dataset.h"
#include "Model.h"

class Algorithm {

protected:
    double learningRate; 

public:
    Algorithm(double lr) : learningRate(lr) {
    }

    virtual Model solve(const Dataset & ds) = 0;
};

#endif