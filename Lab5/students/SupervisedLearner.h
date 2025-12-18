#ifndef __SUPERVISEDLEARNER__
#define __SUPERVISEDLEARNER__

#include "Algorithm.h"
#include "Dataset.h"
#include "Model.h"

class SupervisedLearner {

private:
    Algorithm* algorithm; 
    Dataset dataset;
    Model model;

public:
    SupervisedLearner(Algorithm* alg, Dataset ds) 
        : algorithm(alg), dataset(ds), model(ds.getDim() + 1) {
    }

    void solve() {
        model = algorithm->solve(dataset);
    }

    double predict(const Vector & v) {
        
        return model.predict(v.augment());
    }
};

#endif