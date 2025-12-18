#ifndef __SGD__
#define __SGD__

#include "Algorithm.h"
#include <vector>
#include <algorithm>
#include <random>    

class StochasticGradientDescent : public Algorithm {

private:
    int batchSize;
    int iterations;

public:
    StochasticGradientDescent(double lr, int bs, int it) 
        : Algorithm(lr), batchSize(bs), iterations(it) {
    }

    Vector stochasticGradient(const std::vector<Record> & batch, const Model & m) {
        int dim = m.getParams().getDim();
        Vector sum(dim, 0.0);
        
        int n = batch.size();

        for (int i = 0; i < n; i = i + 1) {
            Record r = batch[i];
            
            Vector x = r.getInput().augment();
            double error = m.predict(x) - r.getOutput();
            
            sum = sum.add(x.multiply(error));
        }
        return sum;
    }

    Model solve(const Dataset & ds) {
        Model m(ds.getDim() + 1);
        std::vector<Record> data = ds.getData();
        for (int i = 0; i < iterations; i = i + 1) {
            
            std::vector<Record> batch;
            std::sample(data.begin(), data.end(), std::back_inserter(batch),
                        batchSize, std::mt19937{std::random_device{}()});
            
            Vector grad = stochasticGradient(batch, m);
            m.update(grad, learningRate);
        }
        return m;
    }
};

#endif