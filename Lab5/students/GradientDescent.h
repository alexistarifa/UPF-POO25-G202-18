#ifndef __GRADIENTDESCENT__
#define __GRADIENTDESCENT__

#include "Algorithm.h"

class GradientDescent : public Algorithm {

private:
    double stoppingCriterion; 

public:
    GradientDescent(double lr, double sc) 
        : Algorithm(lr), stoppingCriterion(sc) {
    }

    Vector gradient(const Dataset & ds, const Model & m) {
        int dim = m.getParams().getDim();
        Vector sum(dim, 0.0);
        
        std::vector<Record> data = ds.getData();
        int n = data.size(); 

        for (int i = 0; i < n; i = i + 1) {
            Record r = data[i];
            Vector x = r.getInput().augment();
            double prediction = m.predict(x);
            double realValue = r.getOutput();
            double error = prediction - realValue;
            Vector step = x.multiply(error);
            sum = sum.add(step);
        }
        
        return sum;
    }

    Model solve(const Dataset & ds) {
        Model m(ds.getDim() + 1);
        
        while (true) {
            Vector grad = gradient(ds, m);
            if (grad.norm() < stoppingCriterion) {
                break;
            }
            
            m.update(grad, learningRate);
        }
        return m;
    }
};

#endif